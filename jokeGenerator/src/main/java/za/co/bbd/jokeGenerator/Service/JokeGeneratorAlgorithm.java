package za.co.bbd.jokeGenerator.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import za.co.bbd.jokeGenerator.Model.Player;
import za.co.bbd.jokeGenerator.Model.PunchLine;

public class JokeGeneratorAlgorithm {
    private List<Player> players;
    private int currentPlayer = 0;
    private final Comparator<Player> compareByScore = Comparator.comparing(Player::getAccumulatedScore).reversed();

    public JokeGeneratorAlgorithm (List<PunchLine> punchlines, List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);                   
    }


    public void endTurn() {
        currentPlayer = (currentPlayer + 1) % players.size();        //changes player for each turn 
    }

    public void pickPunchline(PunchLine punchline) {
        System.out.println(punchline.getScore());  //we may delete this 
        players.get(currentPlayer).increaseScore(punchline.getScore()); //increace the players score for the punchline they've picked 
    }

    public List<Player> getLeaderboard() {
        return players.stream().sorted(compareByScore).collect(Collectors.toList());  //Michael wants to know more about this :-)
    }

}
