import React from "react";
import { Navigate } from "react-router-dom";
import axios from "axios";
import './index.css';

const PrivateRoute = ({ children }) => {
  return localStorage.getItem("email") ? children : <Navigate to="/login" />;
};

export default PrivateRoute;
