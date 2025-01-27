import React from 'react';
import './ButtonStyles.css';

const NavToMyReservations = ({ onNavigate }) => (
  <button className="button" onClick={onNavigate}>
    Moje Rezerwacje
  </button>
);

export default NavToMyReservations;
