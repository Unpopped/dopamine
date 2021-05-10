package com.example.dopamine.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "user")
@NoArgsConstructor

public class Note {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private String title;

    @ManyToOne
    private User user;

    public Note(String text){
        this.text = text;
    }

}
