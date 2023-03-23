package za.co.bbd.jokeGenerator.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "PunchLine")
public class PunchLine {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int punchLineid;

    @Column(name="punchLine")
    private String punchLine;

    @Column(name="score")
    private int score;

    public PunchLine(int score,String punchline) {
        this.score = score;
        this.punchLine = punchline;
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
