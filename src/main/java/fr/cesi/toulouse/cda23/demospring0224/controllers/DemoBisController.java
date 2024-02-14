package fr.cesi.toulouse.cda23.demospring0224.controllers;

import fr.cesi.toulouse.cda23.demospring0224.models.UserPOJO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller HTTP REST only
// @Controller + @ResponseBody
@RestController
@RequestMapping("/public/bis")
public class DemoBisController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> helloYou(@PathVariable("name") String n) {
        return new ResponseEntity<>("Hello " + n, HttpStatus.OK);
    }

    @PostMapping("/hello/json")
    public ResponseEntity<String> helloJson(@RequestBody UserPOJO u) {
        return new ResponseEntity<>("Hello " + u.getName(), HttpStatus.OK);
    }
}
