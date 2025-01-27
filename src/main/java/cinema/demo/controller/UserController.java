package cinema.demo.controller;

import cinema.demo.dto.UserDto;
import cinema.demo.entity.Uzytkownik;
import cinema.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:9990")
    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody Uzytkownik user) {
        if(user.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            if(!user.getHaslo().equals(user.getPowtorzoneHaslo())) {
                return new ResponseEntity<>("Hasła nie są identyczne!", HttpStatus.BAD_REQUEST);
            }

            userRepository.save(user);
            return new ResponseEntity<>("Rejestracja przebiegła pomyślnie!", HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>("Niepoprawny adres e-mail!", HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin(origins = "http://localhost:9990")
    @PostMapping("/auth")
    public ResponseEntity<String> authUser(@RequestBody UserDto userDto) {
        if(userDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            Uzytkownik user = userRepository.findByEmail(userDto.getEmail());

            if(user!=null && user.getHaslo().equals(userDto.getHaslo())) {
                return ResponseEntity.ok("Logowanie udane!");
            }
            else {
                return new ResponseEntity<>("Niepoprawny adres e-mail lub hasło!", HttpStatus.BAD_REQUEST);
            }
        }

        else {
            return new ResponseEntity<>("Niepoprawny adres e-mail!", HttpStatus.BAD_REQUEST);
        }
    }
}
