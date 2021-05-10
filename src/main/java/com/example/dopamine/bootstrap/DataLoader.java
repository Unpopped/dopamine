package com.example.dopamine.bootstrap;

import com.example.dopamine.domain.User;
import com.example.dopamine.domain.Note;
import com.example.dopamine.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner{
    private final UserService userService;

    public DataLoader(@Qualifier("userServiceEm") UserService userService){
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception{
        User u1 = new User("billy","a8cebf1698dc14282c507b1e1cfb7f2c9d5216aa7bd0854b50561e02c2b99d9a38945ec0f81e55f9699062b1eac6d0083411c839ba2b27c6a15b494463bc5c73");
        Note n1 = new Note("Buy a lot of Dogecoin and profit");
        u1.addNote(n1);

        userService.save(u1);
        System.out.println(userService.findAll());
        System.out.println("=======================");
        System.out.println(userService.findUserByUsername("John"));
    }
}
