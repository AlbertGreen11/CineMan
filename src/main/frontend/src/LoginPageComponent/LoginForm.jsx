import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const LoginForm = () => {
  const [email, setEmail] = useState("");
  const [haslo, setHaslo] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [successMessage, setSuccessMessage] = useState(""); // Dodano obsługę sukcesu
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:9998/api/users/auth", {
        email,
        haslo,
      });
      localStorage.setItem("email", email);
      setErrorMessage("");
      setSuccessMessage("Zalogowano!");

      setTimeout(() => {
        navigate("/cineman");
      }, 1000);
    } catch (error) {
      setSuccessMessage("");
      if (error.response && error.response.status === 400) {
        setErrorMessage(error.response.data);
      } else {
        setErrorMessage("An unexpected error occurred.");
      }
      console.log(error);
    }
  };

  return (
    <div className="auth-form">
      <h2>Logowanie</h2>
      <form onSubmit={handleLogin}>
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Wprowadź email"
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Hasło</label>
          <input
            type="password"
            id="password"
            value={haslo}
            onChange={(e) => setHaslo(e.target.value)}
            placeholder="Wprowadź hasło"
            required
          />
        </div>
        <button type="submit" className="login-button">
          Zaloguj się
        </button>

        {errorMessage && <div className="error-message">{errorMessage}</div>}
        {successMessage && <div className="success-message">{successMessage}</div>}
      </form>
    </div>
  );
};

export default LoginForm;
