package fr.cesi.toulouse.cda23.demospring0224.repositories;

import fr.cesi.toulouse.cda23.demospring0224.entities.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    // custom queries

    /**
     * method queries <=> Spring DATA Query methods
     * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
     **/
    public List<Contact> findByFirstnameLike(String firstname);

    /**
     * @Query from Spring DATA (native SQL or JPQL)
     * @param email
     * @return
     */
    @Query(value = "select * from CONTACTS where EMAIL = ?1", nativeQuery = true)
    Contact findByEmailAddress(String email);

}
