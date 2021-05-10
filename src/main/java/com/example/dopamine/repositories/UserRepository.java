package com.example.dopamine.repositories;

import com.example.dopamine.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{

    // get all users
    List<User> findAll();

    // get user by username
    List<User> findUserByUsername(String username);

    // get users with no notes
    List<User> findUsersWithNoNotes();

}
