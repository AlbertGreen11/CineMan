import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Dropdowns.css';  

const CityDropdown = ({ onCitySelect }) => {
    const [cities, setCities] = useState([]);
    const [selectedCity, setSelectedCity] = useState('');

    useEffect(() => {
        
        const fetchCities = async () => {
            try {
                const response = await axios.get('http://localhost:9998/api/cinemas/cities'); 
                setCities(response.data);
            } catch (error) {
                console.error('Błąd podczas pobierania miast:', error);
            }
        };

        fetchCities();
    }, []);

    const handleCitySelect = (e) => {
        const city = e.target.value;
        setSelectedCity(city);
        onCitySelect(city);
    };

    return (
        <div className="select-container">
            <select value={selectedCity} onChange={handleCitySelect}>
                {selectedCity === '' && <option value="">Wybierz miasto</option>}
                {cities.map((city, index) => (
                    <option key={index} value={city}>{city}</option>
                ))}
            </select>
        </div>
    );
};

export default CityDropdown;
