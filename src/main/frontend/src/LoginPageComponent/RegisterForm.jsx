import React, { useState } from "react";
import UserService from "../Service/UserService";

const RegisterForm = () => {
    const [user, setUser] = useState({
        email: "",
        haslo: "",
        powtorzoneHaslo: ""
    });
    const [errorMessage, setErrorMessage] = useState("");
    const [successMessage, setSuccessMessage] = useState(""); // Stan na komunikat o sukcesie

    const handleChange = (e) => {
        const value = e.target.value;
        setUser({ ...user, [e.target.name]: value });
    };

    const RegisterUser = (e) => {
        e.preventDefault();
        console.log(user);
        UserService.saveUser(user)
            .then((res) => {
                console.log("User Added Successfully");
                setUser({
                    email: "",
                    haslo: "",
                    powtorzoneHaslo: ""
                });
                setErrorMessage("");
                setSuccessMessage("Użytkownik został pomyślnie dodany!");
            })
            .catch((error) => {
                setSuccessMessage("");
                if (error.response && error.response.status === 400) {
                    setErrorMessage(error.response.data);
                } else if (error.response && error.response.status === 500) {
                    setErrorMessage("Adres e-mail jest już zajęty!");
                } else {
                    setErrorMessage("Wystąpił nieoczekiwany błąd.");
                }
                console.log(error);
            });
    };

    return (
        <div className="auth-form">
            <h2>Rejestracja</h2>
            <form onSubmit={(e) => RegisterUser(e)}>
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input
                        name="email"
                        onChange={(e) => handleChange(e)}
                        value={user.email}
                        id="email"
                        placeholder="Wprowadź email"
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Hasło</label>
                    <input
                        type="password"
                        name="haslo"
                        onChange={(e) => handleChange(e)}
                        value={user.haslo}
                        id="password"
                        placeholder="Wprowadź hasło"
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="confirm-password">Potwierdź hasło</label>
                    <input
                        type="password"
                        name="powtorzoneHaslo"
                        onChange={(e) => handleChange(e)}
                        value={user.powtorzoneHaslo}
                        id="confirm-password"
                        placeholder="Potwierdź hasło"
                        required
                    />
                </div>

                <button type="submit" className="register-button">
                    Zarejestruj się
                </button>
                
                {errorMessage && <div className="error-message">{errorMessage}</div>}
                {successMessage && <div className="success-message">{successMessage}</div>}
            </form>
        </div>
    );
};

export default RegisterForm;
