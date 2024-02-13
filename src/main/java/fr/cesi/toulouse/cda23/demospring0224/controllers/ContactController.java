package fr.cesi.toulouse.cda23.demospring0224.controllers;

import fr.cesi.toulouse.cda23.demospring0224.entities.Contact;
import fr.cesi.toulouse.cda23.demospring0224.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Contact>> findAll() {
        return new ResponseEntity<>(this.contactService.findAll(), HttpStatus.OK);
    }
}
