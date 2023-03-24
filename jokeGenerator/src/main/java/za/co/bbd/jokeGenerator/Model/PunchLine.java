package za.co.bbd.jokeGenerator.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "PunchLine")
public class PunchLine {

    @Id
    @SequenceGenerator(
            name = "punch_line_sequence",
            sequenceName = "punch_line_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "punch_line_sequence"
    )
    private int punchLineid;

    @Column(name="punchLine")
    private String punchLine;

    @Column(name="score")
    private int score;

   

    public PunchLine(int score, String punchline) {
        this.score = score;
        this.punchLine = punchline;
    }

    public PunchLine() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setPunchline(String punchline){   //might want to change method name 
        this.punchLine = punchline;
    }

    public String getPunchLine(){
        return this.punchLine; 
    }

    public int getPunchLineid() {
        return punchLineid;
    }

    public void setPunchLineid(int punchLineid) {
        this.punchLineid = punchLineid;
    }

}
