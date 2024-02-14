package fr.cesi.toulouse.cda23.demospring0224.controllers;

import fr.cesi.toulouse.cda23.demospring0224.entities.User;
import fr.cesi.toulouse.cda23.demospring0224.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> signin(@RequestBody User user) {
        return new ResponseEntity<>(this.authService.loginUser(user), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> signup(@RequestBody User user) { // Partial User
        return new ResponseEntity<>(this.authService.registerUser(user), HttpStatus.OK);
    }
}
