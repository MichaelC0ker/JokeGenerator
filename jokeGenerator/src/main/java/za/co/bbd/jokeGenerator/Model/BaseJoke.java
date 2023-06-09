package za.co.bbd.jokeGenerator.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "BaseJoke")
public class BaseJoke {
    
    @Id
    @SequenceGenerator(
            name = "base_joke_sequence",
            sequenceName = "base_joke_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy=GenerationType.AUTO,
            generator = "base_joke_sequence"
    )
    private int baseJokeid;

    @Column(name="baseJoke")
    private String baseJoke;

    public BaseJoke(){}

    public BaseJoke( String baseJoke) {
        this.baseJoke = baseJoke;
    }

    public BaseJoke(int baseJokeid, String baseJoke) {
        this.baseJokeid = baseJokeid;
        this.baseJoke = baseJoke;
    }

    public int getBaseJokeid() {return baseJokeid;}

    public void setBaseJokeid(int baseJokeid) {
        this.baseJokeid = baseJokeid;
    }

    public String getBaseJoke() {
        return baseJoke;
    }

    public void setBaseJoke(String baseJoke) {
        this.baseJoke = baseJoke;
    }

}
