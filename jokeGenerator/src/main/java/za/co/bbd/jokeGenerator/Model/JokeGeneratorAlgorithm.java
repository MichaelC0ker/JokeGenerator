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

}
