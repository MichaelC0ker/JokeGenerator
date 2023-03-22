package za.co.bbd.jokeGenerator;

import java.lang.Math;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class JokeGeneratorAlgorithm {
    private List<Player> players;
    private final Comparator<Player> compareByScore = Comparator
            .comparing(Player::getAccumulatedScore).reversed();

    public JokeGeneratorAlgorithm(List<Player> players) {
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

    public void playGame() {
        int pick = -1;
        String gameData = "";
        for (int roundNum = 1; roundNum <= 3; roundNum++) {
            gameData = "";
            // for every round, we show a base joke and 5 punchlines
            Joke roundJoke = new Joke();
            gameData += "Round " + roundNum + "\nBase Joke:\n  " + roundJoke.getBaseJoke() + "\nPunchlines:\n";
            List<Punchline> punchlines = roundJoke.getPunchlines();
            int punchlineCount = 1;
            for (Punchline p : punchlines) {
                gameData += punchlineCount + ". " + p.getPunchLine() + "\n";
                punchlineCount++;
            }

            // we then give each player a turn to pick a punchline
            for (Player pl : players) {
                if (players.get(currentPlayer).getName().equals("AI")) {
                     pick = (int)(Math.random()*5); //pick a random number between 1 and 5 for the AI 
                } else {
                     pick = Integer
                            .parseInt(JOptionPane.showInputDialog(gameData + "\n\nWhich punchline fits in well with the base joke?")); //as user for input 
                }
            System.out.println("Punchline size " + punchlines.size() + "\nPick-- " + pick--);
                pickPunchline(punchlines.get(pick--));
                endTurn();
            }

        }
    }
}
