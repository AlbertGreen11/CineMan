import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Dropdowns.css';  

const CinemaDropdown = ({ city, onCinemaSelect }) => {
    const [cinemas, setCinemas] = useState([]);
    const [selectedCinema, setSelectedCinema] = useState('');

    useEffect(() => {
        if (!city) return;

        
        setSelectedCinema('');
        setCinemas([]);

        
        const fetchCinemas = async () => {
            try {
                const response = await axios.get(`http://localhost:9998/api/cinemas/${city}`); 
                setCinemas(response.data); 
                onCinemaSelect("")
            } catch (error) {
                console.error('Błąd podczas pobierania kin:', error);
            }
        };

        fetchCinemas();
    }, [city]);

    if (!city || cinemas.length === 0) return null; 

    const handleCinemaSelect = (e) => {
        const cinema = e.target.value;
        setSelectedCinema(cinema);
        onCinemaSelect(cinema);
    };

    return (
        <div className="select-container">
            <select value={selectedCinema} onChange={handleCinemaSelect}>
                <option value="">Wybierz kino</option>
                {cinemas.map((cinema, index) => (
                    <option key={index} value={cinema}>{cinema}</option>
                ))}
            </select>
        </div>
    );
};

export default CinemaDropdown;
