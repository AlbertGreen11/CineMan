import React, { useState } from "react";
import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";
import "./AuthForm.css"

const AuthForm = () => {
  const [isLogin, setIsLogin] = useState(true);

  const toggleForm = () => {
    setIsLogin(!isLogin);
  };

  return (
    <div className="auth-container">
      {isLogin ? <LoginForm /> : <RegisterForm />}
      <p className="toggle-text">
        {isLogin ? "Nie masz konta? " : "Masz już konto? "} 
        <span onClick={toggleForm} className="toggle-link">
          {isLogin ? "Zarejestruj się" : "Zaloguj się"}
        </span>
      </p>
    </div>
  );
};

export default AuthForm;