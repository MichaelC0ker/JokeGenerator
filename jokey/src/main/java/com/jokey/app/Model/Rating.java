package com.jokey.app.Model;

import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {
    
    @Id
    private int ratingId;

    @Column(name="baseJokeId")
    private int baseJokeid;

    @Column(name="punchLineid")
    private int punchLineid;

    @Column(name="rating")
    private TinyIntJdbcType rating;

}
