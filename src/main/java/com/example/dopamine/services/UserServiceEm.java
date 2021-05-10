package com.example.dopamine.services;

import com.example.dopamine.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceEm implements UserService{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public List<User> findUserByUsername(String username) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        return query.getResultList();
    }

    @Override
    public List<User> findUsersWithNoNotes() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.notes IS EMPTY", User.class);
        return query.getResultList();
    }

}
