package za.co.bbd.jokeGenerator.Model;

//check if exists in the db
public class Player {
    private final String name;
    private int accumulatedScore = 0;

    public Player(String name) {
        this.name = name;
    }

    public int increaseScore(int score) {
        accumulatedScore += score;
        return accumulatedScore;
    }

    public int getAccumulatedScore() {
        return accumulatedScore;
    }

    public void resetScore() {
        accumulatedScore = 0;
    }

    @Override
    public String toString() {
        return name + ": " + accumulatedScore;
    }

    public String getName() {
        return name;
    }

    public void setAccumulatedScore(int accumulatedScore) {
        this.accumulatedScore = accumulatedScore;
    }
}
