import React, { useState, useEffect } from 'react';
import CityDropdown from './CityDropdown';
import ShowtimesDisplay from './ShowtimesDisplay';
import CinemaDropdown from './CinemaDropdown';

const Cineman = () => {
    const [selectedCity, setSelectedCity] = useState("");
    const [selectedCinema, setSelectedCinema] = useState("");

    return (
        <div className='seanse'>
            <h1>Seanse</h1>
            <CityDropdown onCitySelect={(city) => setSelectedCity(city)} />
            <CinemaDropdown city={selectedCity} onCinemaSelect={(cinema) => setSelectedCinema(cinema)} />
            <ShowtimesDisplay cinema={selectedCinema} />
        </div>
    );
};
  
export default Cineman;