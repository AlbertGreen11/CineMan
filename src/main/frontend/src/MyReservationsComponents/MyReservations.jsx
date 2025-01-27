import React, { useState, useEffect } from 'react';
import axios from 'axios';
import MenuComponent from "../MenuComponents/MenuComponent";
import './MyReservations.css';

const MyReservations = () => {
    const [reservations, setReservations] = useState([]);
    const [message, setMessage] = useState('');

    useEffect(() => {
        const fetchReservations = async () => {
            try {
                const email = localStorage.getItem("email");
                const response = await axios.post(`http://localhost:9998/api/my-reservations`, { email });
                setReservations(response.data);
            } catch (error) {
                console.error('Błąd podczas pobierania rezerwacji:', error);
                setMessage('Wystąpił błąd podczas pobierania rezerwacji.');
            }
        };

        fetchReservations();
    }, []);

    const cancelReservation = async (rezerwacjaID) => {
        try {
            await axios.delete(`http://localhost:9998/api/my-reservations/cancel/${rezerwacjaID}`);
            window.location.reload();
            
        } catch (error) {
            console.error("Błąd podczas anulowania rezerwacji:", error);
            alert("Wystąpił błąd podczas anulowania rezerwacji.");
        }
    };

    return (
        <div>
            <MenuComponent />
            <div className="reservations-container">
                <h2>Moje Rezerwacje</h2>
                {message && <p className="error-message">{message}</p>}

                {reservations.length === 0 ? (
                    <p>Brak zarezerwowanych miejsc.</p>
                ) : (
                    <ul className="reservations-list">
                        {reservations.map((reservation) => (
                            <li
                                key={reservation.rezerwacjaID}
                                className="reservation-item"
                            >
                                <img
                                    src={reservation.urlPlakatu}
                                    alt={reservation.tytul}
                                    className="reservation-poster"
                                />
                                <div className="reservation-details">
                                    <p><strong>Tytuł:</strong> {reservation.tytul}</p>
                                    <p><strong>Data seansu:</strong> {reservation.dataSeansu}</p>
                                    <p><strong>Godzina seansu:</strong> {reservation.godzinaSeansu}</p>
                                    <p><strong>Miasto:</strong> {reservation.miasto}</p>
                                    <p><strong>Nazwa kina:</strong> {reservation.nazwaKina}</p>
                                    <p><strong>Miejsca:</strong> {reservation.miejsca.join(', ')}</p>
                                </div>
                                <button
                                    className="cancel-reservation-button"
                                    onClick={() => cancelReservation(reservation.rezerwacjaID)}
                                >
                                    Anuluj rezerwację
                                </button>
                            </li>
                        ))}
                    </ul>
                )}
            </div>
        </div>
    );
};

export default MyReservations;
