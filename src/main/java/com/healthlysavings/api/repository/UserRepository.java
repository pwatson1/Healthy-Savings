package com.healthlysavings.api.repository;



import com.healthlysavings.api.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jrdavis on 3/7/16.
 */

// Imports ...

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    public User findByEmail(String email);
    public User findById(Long id);

}