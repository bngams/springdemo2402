package fr.cesi.toulouse.cda23.demospring0224.services;

import fr.cesi.toulouse.cda23.demospring0224.entities.Contact;
import fr.cesi.toulouse.cda23.demospring0224.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    private ContactRepository contactRepo;

    @Autowired
    public ContactService(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    public Contact findById(Integer id) {
        return this.contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Iterable<Contact> findAll() {
        return this.contactRepo.findAll();
    }
}
