# 🎬 Cineman - Rezerwacja miejsc w kinie online

Cineman to aplikacja webowa umożliwiająca rezerwację miejsc na seanse kinowe online. Dzięki technologii Spring Boot 3, React oraz H2 Database, zapewniamy szybkie i intuicyjne doświadczenie użytkownika.

## ✨ Funkcjonalności

- **Rejestracja i logowanie:**
  - Walidacja poprawności danych podczas rejestracji i logowania.
- **Przegląd seansów:**
  - Możliwość przeglądania seansów w różnych miastach.
  - Filtracja według wybranego dnia.
- **Rezerwacja miejsc:**
  - Rezerwacja miejsc na wybrany seans.
  - Dodawanie rezerwacji do zakładki "Moje Rezerwacje".
- **Zarządzanie rezerwacjami:**
  - Podgląd wszystkich dokonanych rezerwacji w zakładce "Moje Rezerwacje".
  - Anulowanie rezerwacji, co automatycznie zwalnia zarezerwowane miejsce.

## 🛠️ Wymagania

- Java 23+
- Node.js 23+
- NPM 11+
- Gradle (wbudowany wrapper `./gradlew`)

## 🚀 Uruchamianie aplikacji

### 🖥️ Backend
1. Przejdź do głównego folderu projektu `lab-prog-awrsp-2024-2025-assessment-project-gr-5`.
2. Wykonaj komendę:
   ```bash
   ./gradlew bootRun
   ```
3. Backend zostanie uruchomiony na porcie `9998`.

### 🌐 Frontend
1. Przejdź do folderu `src/main/frontend`.
2. Zainstaluj npm komendą:
   ```bash
   npm install
   ```
3. Uruchom komendę:
   ```bash
   npm start
   ```
4. Frontend zostanie uruchomiony na porcie `9990`.

### 🌍 Dostęp do aplikacji
Aplikacja jest dostępna pod adresem: [http://localhost:9990/](http://localhost:9990/)

## 🛠️ Technologia

- **Backend:** Spring Boot 3
- **Frontend:** React
- **Baza danych:** H2 Database

## 👥 Autorzy
- Albert Pacocha
- Daniel Pacocha

**Życzymy udanego korzystania z aplikacji Cineman!** 🎥🍿
