package com.example.dopamine.services;

import com.example.dopamine.domain.User;
import com.example.dopamine.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> findUsersWithNoNotes() {
        return userRepository.findUsersWithNoNotes();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
