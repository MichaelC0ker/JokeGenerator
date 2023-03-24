package za.co.bbd.jokeGenerator.Model;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import za.co.bbd.jokeGenerator.Model.Player;
import za.co.bbd.jokeGenerator.Model.PunchLine;

public class JokeGeneratorAlgorithm {
    private List<Player> players;
    private List<PunchLine> punchLines;
    private int currentPlayer = 0;

    public JokeGeneratorAlgorithm (List<PunchLine> punchlines, List<Player> players) {
        this.players = players;
        this.punchLines = punchlines;
    }

    public JokeGeneratorAlgorithm () {
    }

    public List<PunchLine> getPunchLines() {
        return punchLines;
    }

    public void setPunchLines(List<PunchLine> punchLines) {
        this.punchLines = punchLines;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);                   
    }
    //aslk about that
    public int getCurrentPlayerVal(){
        return this.currentPlayer;
    }

    public void setCurrentPlayerVal(int currentplayerVal){
        this.currentPlayer = currentplayerVal;
    }

//    public void endTurn() {
//        currentPlayer = (currentPlayer + 1) % players.size();        //changes player for each turn
//    }

//    public void pickPunchline(PunchLine punchline) {
//        System.out.println(punchline.getScore());  //we may delete this
//        players.get(currentPlayer).increaseScore(punchline.getScore()); //increace the players score for the punchline they've picked
//    }
//
//    public List<Player> getLeaderboard() {
//        return players.stream().sorted(compareByScore).collect(Collectors.toList());  //Michael wants to know more about this :-)
//    }
//    private final Comparator<Player> compareByScore = Comparator.comparing(Player::getAccumulatedScore).reversed();

}
