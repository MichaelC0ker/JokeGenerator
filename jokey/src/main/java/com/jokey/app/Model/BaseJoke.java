package com.jokey.app.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//add getters and setters
@Entity
@Table(name = "BaseJoke")
public class BaseJoke {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int baseJokeid;

    @Column(name="baseJoke")
    private String baseJoke;

}
