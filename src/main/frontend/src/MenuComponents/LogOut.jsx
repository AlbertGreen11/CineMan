import React from 'react';
import './ButtonStyles.css';

const LogOut = ({ onNavigate }) => {
  const handleLogout = () => {
    localStorage.removeItem('email');
    onNavigate();
  };

  return (
    <button className="button logout-button" onClick={handleLogout}>
      Wyloguj się
    </button>
  );
};

export default LogOut;
