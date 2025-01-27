package cinema.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import cinema.demo.dto.UserDto;
import cinema.demo.entity.Uzytkownik;
import cinema.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    private Uzytkownik validUser;
    private UserDto validUserDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Przygotowanie testowych danych użytkownika
        validUser = new Uzytkownik();
        validUser.setEmail("test@example.com");
        validUser.setHaslo("password123");
        validUser.setPowtorzoneHaslo("password123");

        validUserDto = new UserDto();
        validUserDto.setEmail("test@example.com");
        validUserDto.setHaslo("password123");
    }

    @Test
    public void testSaveUser_ValidInput() {
        // Given
        when(userRepository.save(any(Uzytkownik.class))).thenReturn(validUser);

        // When
        ResponseEntity<String> response = userController.saveUser(validUser);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Rejestracja przebiegła pomyślnie!", response.getBody());
        verify(userRepository, times(1)).save(validUser);
    }

    @Test
    public void testSaveUser_InvalidEmail() {
        // Given
        validUser.setEmail("invalid-email");

        // When
        ResponseEntity<String> response = userController.saveUser(validUser);

        // Then
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Niepoprawny adres e-mail!", response.getBody());
    }

    @Test
    public void testSaveUser_PasswordsDontMatch() {
        // Given
        validUser.setPowtorzoneHaslo("differentPassword");

        // When
        ResponseEntity<String> response = userController.saveUser(validUser);

        // Then
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Hasła nie są identyczne!", response.getBody());
    }

    @Test
    public void testAuthUser_ValidCredentials() {
        // Given
        when(userRepository.findByEmail(validUserDto.getEmail())).thenReturn(validUser);

        // When
        ResponseEntity<String> response = userController.authUser(validUserDto);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Logowanie udane!", response.getBody());
        verify(userRepository, times(1)).findByEmail(validUserDto.getEmail());
    }

    @Test
    public void testAuthUser_InvalidEmail() {
        // Given
        validUserDto.setEmail("invalid-email");

        // When
        ResponseEntity<String> response = userController.authUser(validUserDto);

        // Then
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Niepoprawny adres e-mail!", response.getBody());
    }

    @Test
    public void testAuthUser_InvalidPassword() {
        // Given
        validUserDto.setHaslo("wrongPassword");
        when(userRepository.findByEmail(validUserDto.getEmail())).thenReturn(validUser);

        // When
        ResponseEntity<String> response = userController.authUser(validUserDto);

        // Then
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Niepoprawny adres e-mail lub hasło!", response.getBody());
    }

    @Test
    public void testAuthUser_UserNotFound() {
        // Given
        when(userRepository.findByEmail(validUserDto.getEmail())).thenReturn(null);

        // When
        ResponseEntity<String> response = userController.authUser(validUserDto);

        // Then
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Niepoprawny adres e-mail lub hasło!", response.getBody());
    }
}
