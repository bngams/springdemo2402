package fr.cesi.toulouse.cda23.demospring0224.services;

import fr.cesi.toulouse.cda23.demospring0224.entities.User;
import fr.cesi.toulouse.cda23.demospring0224.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class AuthService {

    private UserRepository userRepo;

    @Autowired
    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User registerUser(User u) {
        this.hashUserPassword(u);
        return this.userRepo.save(u);
    }

    public String loginUser(User u) {
        User connected = this.userRepo.findFirstByEmailAndPassword(u.getEmail(), this.hashPassword(u.getPassword()))
                .orElseThrow(() -> new RuntimeException("Login failed"));
        String token = "XYZ";
        return token;
    }

    private void hashUserPassword(User u) {
        u.setPassword(this.hashPassword(u.getPassword()));
    }

    private String hashPassword(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
