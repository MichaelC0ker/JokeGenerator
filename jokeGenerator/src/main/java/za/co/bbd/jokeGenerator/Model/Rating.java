package za.co.bbd.jokeGenerator.Model;

import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rating")
public class Rating {
    
    @Id
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
