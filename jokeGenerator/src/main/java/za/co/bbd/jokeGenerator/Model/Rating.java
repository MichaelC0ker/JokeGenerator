package za.co.bbd.jokeGenerator.Model;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Rating")
public class Rating {

    @Id
    @SequenceGenerator(
            name = "rating_sequence",
            sequenceName = "rating_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rating_sequence"
    )
    private int ratingId;

    @Column(name="baseJokeId")
    private int baseJokeid;

    @Column(name="punchLineid")
    private int punchLineid;

    @Column(name="rating")
    private TinyIntJdbcType rating;

    public Rating(){}

    public Rating( int baseJokeid, int punchLineid, TinyIntJdbcType rating) {
        this.baseJokeid = baseJokeid;
        this.punchLineid = punchLineid;
        this.rating = rating;
    }

    public Rating(int ratingId, int baseJokeid, int punchLineid, TinyIntJdbcType rating) {
        this.ratingId = ratingId;
        this.baseJokeid = baseJokeid;
        this.punchLineid = punchLineid;
        this.rating = rating;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getBaseJokeid() {
        return baseJokeid;
    }

    public void setBaseJokeid(int baseJokeid) {
        this.baseJokeid = baseJokeid;
    }

    public int getPunchLineid() {
        return punchLineid;
    }

    public void setPunchLineid(int punchLineid) {
        this.punchLineid = punchLineid;
    }

    public TinyIntJdbcType getRating() {
        return rating;
    }

    public void setRating(TinyIntJdbcType rating) {
        this.rating = rating;
    }

}
