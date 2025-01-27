import React from 'react';
import './ButtonStyles.css';

const NavToCineman = ({ onNavigate }) => (
  <button className="button" onClick={onNavigate}>
    Cineman
  </button>
);

export default NavToCineman;
