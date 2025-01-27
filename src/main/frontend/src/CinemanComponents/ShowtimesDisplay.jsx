import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';  
import './ShowtimesDisplay.css';  

const ShowtimesDisplay = ({ cinema }) => {
    const [showtimes, setShowtimes] = useState([]);
    const [selectedDate, setSelectedDate] = useState(null);
    const [dates, setDates] = useState([]);
    const navigate = useNavigate();  

    useEffect(() => {
        if (!cinema) return;

        
        const fetchShowtimes = async () => {
            try {
                const response = await axios.get(`http://localhost:9998/api/showtimes/${cinema}`);
                setShowtimes(response.data);

                
                const availableDates = response.data.map(show => show.dataSeansu);
                const uniqueDates = [...new Set(availableDates)];  
                setDates(uniqueDates);

                
                if (uniqueDates.length > 0) {
                    setSelectedDate(uniqueDates[0]);
                }
            } catch (error) {
                console.error('Błąd podczas pobierania seansów:', error);
            }
        };

        fetchShowtimes();
    }, [cinema]);

    const handleDateSelect = (date) => {
        setSelectedDate(date);
    };

    const handleMovieClick = (seansID) => {
        
        navigate(`/cineman/${seansID}/seats`);
    };

    if (!cinema) return null; 

    
    const filteredShowtimes = showtimes.filter(show => show.dataSeansu === selectedDate);

    return (
        <div className="showtimes-container">
            <div className="date-buttons">
                {dates.map((date, index) => (
                    <button
                        key={index}
                        className={`date-button ${selectedDate === date ? 'active' : ''}`}
                        onClick={() => handleDateSelect(date)}
                    >
                        {date}
                    </button>
                ))}
            </div>

            {filteredShowtimes.length === 0 ? (
                <p>Brak seansów do wyświetlenia na wybraną datę.</p>
            ) : (
                <ul className="showtimes-list">
                    {filteredShowtimes.map((show) => (
                        <li 
                            key={show.seansID} 
                            className="showtime-item"
                            onClick={() => handleMovieClick(show.seansID)}  
                        >
                            <img src={show.film.urlPlakatu} alt={show.film.tytul} className="showtime-poster" />
                            <div className="showtime-details">
                                <p><strong>Tytuł:</strong> {show.film.tytul}</p>
                                <p><strong>Gatunek:</strong> {show.film.gatunek}</p>
                                <p><strong>Godzina:</strong> {show.godzinaSeansu}</p>
                                <p><strong>Czas trwania:</strong> {show.film.czasTrwania} min</p>
                            </div>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default ShowtimesDisplay;
