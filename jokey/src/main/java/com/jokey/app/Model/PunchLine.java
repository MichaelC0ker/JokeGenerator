package com.jokey.app.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PunchLine")
public class PunchLine {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int punchLineid;

    @Column(name="punchLine")
    private String punchLine;



}
