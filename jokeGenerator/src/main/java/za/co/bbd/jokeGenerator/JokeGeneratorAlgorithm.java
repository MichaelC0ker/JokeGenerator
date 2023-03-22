package za.co.bbd.jokeGenerator;

import java.lang.Math;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

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
        players.get(currentPlayer).increaseScore(punchline.getScore());
    }

    public List<Player> getLeaderboard() {
        return players.stream().sorted(compareByScore).collect(Collectors.toList());
    }

    private List<Joke> getJokes(){
        List<Joke> jokes = new ArrayList<>();
        for(int i = 0;i<3;i++){
            jokes.add(new Joke());
        }
        return jokes;
    }

    public void playGame() {
        int pick = -1;
        String gameData = "";
        List<Joke> jokes = getJokes();

        for (int roundNum = 1; roundNum <= 3; roundNum++) {
            gameData = "";
            // for every round, we show a base joke and 5 punchlines
            gameData += "Round " + roundNum + "\nBase Joke:\n  " + jokes.get(roundNum-1).getBaseJoke() + "\nPunchlines:\n";
            List<Punchline> punchlines = jokes.get(roundNum-1).getPunchlines();
            int punchlineCount = 1;
            for (Punchline p : punchlines) {
                gameData += punchlineCount + ". " + p.getPunchLine() + " = "+p.getScore()+ "\n";
                punchlineCount++;
            }

            // we then give each player a turn to pick a punchline
            for (Player pl : players) {
                if (players.get(currentPlayer).getName().equals("AI")) {
                    pick = (int) (Math.random() * 4) + 1; // pick a random number between 1 and 5 for the AI
                    System.out.println("pick by AI:" + pick);

                    // System.out.println("pick:" + pick);

                } else {
                    pick = Integer
                            .parseInt(JOptionPane.showInputDialog(
                                    gameData + "\n\nWhich punchline fits in well with the base joke?")); // as user for
                                                                                                         // input
                    System.out.println("pick by real player:" + pick);
                  //  System.out.println(pun-chlines.get(pick--).getScore());


                }
                // System.out.println("Punchline size " + punchlines.size() + "\nPick--: " +
                // pick--);
                pickPunchline(punchlines.get(pick-1));
                endTurn();
            }

        }
    }
}
