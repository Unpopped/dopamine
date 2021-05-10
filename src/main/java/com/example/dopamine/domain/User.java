package com.example.dopamine.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "notes")
@NoArgsConstructor


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Note>  notes = new HashSet<>();

    public void addNote(Note n){
        notes.add(n);
        n.setUser(this);
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
