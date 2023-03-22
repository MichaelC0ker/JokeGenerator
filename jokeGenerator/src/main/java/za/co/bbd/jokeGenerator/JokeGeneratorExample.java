package za.co.bbd.jokeGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class JokeGeneratorExample {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player"));
        players.add(new Player("AI"));            //we're creating 2 players 

        JokeGeneratorAlgorithm jga = new JokeGeneratorAlgorithm(players);
        jga.playGame();
       // boolean decided = false;
        for (Player player : jga.getLeaderboard()) {
      
            System.out.println(player);
        }

    }
}