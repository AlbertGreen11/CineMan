import React from 'react';
import './App.css';
import { Route, Routes, Navigate } from 'react-router-dom';
import Cineman from './CinemanComponents/Cineman';
import PrivateRoute from './PrivateRoute';
import AuthForm from './LoginPageComponent/AuthForm';
import MenuComponent from './MenuComponents/MenuComponent';
import Seats from './SeatsComponents/Seats';
import MyReservations from './MyReservationsComponents/MyReservations';

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/cineman" />} />
      <Route path='/cineman' element={
        <PrivateRoute>
          <MenuComponent />
          <Cineman />
        </PrivateRoute>
        }/>
      <Route path='/login' element={<AuthForm />}/>
      <Route path="/cineman/:id/seats" element={
      <PrivateRoute>
        <Seats />
      </PrivateRoute>
      }/>

      <Route path="/my-reservations" element={
      <PrivateRoute>
        <MyReservations />
      </PrivateRoute>
      } />
    </Routes>
  );
};

export default App;