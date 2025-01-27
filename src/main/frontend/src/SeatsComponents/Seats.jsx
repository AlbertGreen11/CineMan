import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Seats.css';
import MenuComponent from '../MenuComponents/MenuComponent';

const Seats = () => {
    const { id } = useParams();
    const navigate = useNavigate();

    const [showDetails, setShowDetails] = useState(null);
    const [seats, setSeats] = useState([]);
    const [selectedSeats, setSelectedSeats] = useState([]);
    const [message, setMessage] = useState('');
    const [messageType, setMessageType] = useState('');

    useEffect(() => {
        axios.get(`http://localhost:9998/api/showtimes/showtime/${id}`)
            .then(response => {
                setShowDetails(response.data);
            })
            .catch(error => {
                console.error("Błąd pobierania szczegółów filmu:", error);
            });

        axios.get(`http://localhost:9998/api/showtime/${id}/seats`)
            .then(response => {
                setSeats(response.data);
            })
            .catch(error => {
                console.error("Błąd pobierania miejsc:", error);
            });
    }, [id]);

    const handleSeatClick = (seat) => {
        if (!seat.rezerwacjaID) {
            setSelectedSeats((prevSelected) => {
                if (prevSelected.includes(seat)) {
                    return prevSelected.filter(s => s !== seat);
                } else {
                    return [...prevSelected, seat];
                }
            });
        }
    };

    const handleCancel = () => {
        navigate('/cineman');
    };

    const handleReserve = async () => {
        if (selectedSeats.length === 0) {
            setMessage('Proszę wybrać przynajmniej jedno miejsce!');
            setMessageType('error');
            return;
        }

        const seatIDs = selectedSeats.map(seat => seat.miejsceID);

        const email = localStorage.getItem("email");
        
        try {
            const rezerwacjaID = (await axios.post(`http://localhost:9998/api/reservations`, { email })).data;

            const sendedData = {
                miejsceIDs: seatIDs,
                rezerwacjaID: rezerwacjaID
            };

            await axios.put(`http://localhost:9998/api/showtime/reserve-seats`, sendedData);
            
            setMessage('Miejsca zostały pomyślnie zarezerwowane!');
            setMessageType('success');

            setTimeout(() => {
                navigate('/my-reservations');
            }, 500);

        } catch (error) {
            console.error("Błąd rezerwacji:", error);
            setMessage('Wystąpił błąd przy rezerwacji miejsc.');
            setMessageType('error');
        }
    };

    if (!showDetails || seats.length === 0) return <p>Ładowanie danych...</p>;

    const seatsByRow = seats.reduce((rows, seat) => {
        if (!rows[seat.rzad]) rows[seat.rzad] = [];
        rows[seat.rzad].push(seat);
        return rows;
    }, {});

    return (
        <div className="seats-container">
            <MenuComponent />
            <div className="movie-details">
                <img 
                    src={showDetails.film.urlPlakatu} 
                    alt={showDetails.film.tytul} 
                    className="movie-poster"
                />
                <div className="details-content">
                    <p><strong>Tytuł:</strong> {showDetails.film.tytul}</p>
                    <p><strong>Gatunek:</strong> {showDetails.film.gatunek}</p>
                    <p><strong>Data seansu:</strong> {showDetails.dataSeansu}</p>
                    <p><strong>Godzina:</strong> {showDetails.godzinaSeansu}</p>
                    <p><strong>Czas trwania:</strong> {showDetails.film.czasTrwania} min</p>
                    <p><strong>Miasto:</strong> {showDetails.kino.miasto}</p>
                    <p><strong>Kino:</strong> {showDetails.kino.nazwa}</p>
                </div>
            </div>

            <div className="seats-grid">
                <div className="screen">Ekran</div>
                {Object.entries(seatsByRow).map(([row, seatsInRow]) => (
                    <div key={row} className="seat-row">
                        {seatsInRow.map((seat) => (
                            <div 
                                key={seat.miejsceID} 
                                className={`seat ${seat.rezerwacjaID ? 'reserved' : ''} ${selectedSeats.includes(seat) ? 'selected' : ''}`}
                                onClick={() => handleSeatClick(seat)}
                            >
                                {`${row}${seat.numerMiejsca}`}
                            </div>
                        ))}
                    </div>
                ))}
            </div>

            <div className="actions">
                <button className="cancel-button" onClick={handleCancel}>Anuluj</button>
                <button className="reserve-button" onClick={handleReserve}>Zarezerwuj</button>
            </div>

            {message && (
                <div className={`message ${messageType}`}>
                    {message}
                </div>
            )}
        </div>
    );
};

export default Seats;
