package com.example.dopamine.services;

import com.example.dopamine.domain.User;
import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    List<User> findUserByUsername(String username);
    List<User> findUsersWithNoNotes();

}
