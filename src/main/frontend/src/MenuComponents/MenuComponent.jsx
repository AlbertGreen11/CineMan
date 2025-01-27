import React from 'react';
import { useNavigate } from 'react-router-dom';
import NavToCineman from './NavToCineman';
import NavToMyReservations from './NavToMyReservations';
import LogOut from './LogOut';
import './MenuComponent.css';
import logo from '../logo.png';

const MenuComponent = () => {
  const navigate = useNavigate();
  const userEmail = localStorage.getItem('email');

  const handleNavigation = (endpoint) => {
    navigate(endpoint);
  };

  const handleLogoClick = () => {
    navigate('/cineman');
  };

  return (
    <div className="menu-container">
      <div className="menu-content">
        <div className="logo-container" onClick={handleLogoClick}>
          <img src={logo} alt="Logo" className="logo" />
        </div>

        <div className="menu-text">
          <div className="welcome-message">
            <p className="greeting">Witaj, </p>
            <p className="user-email">{userEmail}</p>
          </div>

          <div className="menu-options animated-options">
            <NavToCineman onNavigate={() => handleNavigation('/cineman')} />
            <NavToMyReservations onNavigate={() => handleNavigation('/my-reservations')} />
            <LogOut onNavigate={() => handleNavigation('/login')} />
          </div>
        </div>
      </div>

      <hr className="menu-options-line" />
    </div>
  );
};

export default MenuComponent;
