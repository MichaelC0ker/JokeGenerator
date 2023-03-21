package za.co.bbd.jokeGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JokeGeneratorAlgorithm {
    private List<Player> players;
    private final Comparator<Player> compareByScore = Comparator
            .comparing(Player::getAccumulatedScore).reversed();

    public JokeGeneratorAlgorithm (List<Punchline> punchlines, List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private int currentPlayer = 0;

    public void endTurn() {
        currentPlayer = (currentPlayer + 1) % players.size();
    }

    public void pickPunchline(Punchline punchline) {
        System.out.println(punchline.getScore());
        players.get(currentPlayer).increaseScore(punchline.getScore());
    }

    public List<Player> getLeaderboard() {
        return players.stream().sorted(compareByScore).collect(Collectors.toList());
    }
}
