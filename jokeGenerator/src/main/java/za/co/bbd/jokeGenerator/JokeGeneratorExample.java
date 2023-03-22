package za.co.bbd.jokeGenerator;

import java.util.ArrayList;
import java.util.List;

public class JokeGeneratorExample {
    public static void main(String[] args) {
        Joke jk = new Joke();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player"));
        players.add(new Player("AI"));            //we're creating 2 players 

        JokeGeneratorAlgorithm jga = new JokeGeneratorAlgorithm(players);
        jga.playGame();

        for (Player player : jga.getLeaderboard()) {
            System.out.println(player);
        }
    }
}