package za.co.bbd.jokeGenerator;

public class Punchline {
    private int score;
    private String punchline;

    public Punchline(int score,String punchline) {
        this.score = score;
        this.punchline = punchline;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setPunchline(String punchline){   //might want to change method name 
        this.punchline = punchline;
    }

    public String getPunchLine(){
        return this.punchline; 
    }

}
