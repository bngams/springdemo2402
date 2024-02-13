package fr.cesi.toulouse.cda23.demospring0224.controllers;

import fr.cesi.toulouse.cda23.demospring0224.models.User;
import org.springframework.web.bind.annotation.*;

// Controller HTTP REST only
// @Controller + @ResponseBody
@RestController
@RequestMapping("/bis")
public class DemoBisController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/hello/{name}")
    public String helloYou(@PathVariable("name") String n) {
        return "Hello " + n;
    }

    @PostMapping("/hello/json")
    public String helloJson(@RequestBody User u) {
        return "Hello " + u.getName();
    }
}
