package fr.cesi.toulouse.cda23.demospring0224.repositories;

import fr.cesi.toulouse.cda23.demospring0224.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public Optional<User> findFirstByEmailAndPassword(String email, String hash);
}
