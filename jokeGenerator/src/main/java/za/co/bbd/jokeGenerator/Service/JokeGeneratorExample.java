package za.co.bbd.jokeGenerator.Service;

import java.util.ArrayList;
import java.util.List;

// import za.co.bbd.jokeGenerator.Model.Joke;
import za.co.bbd.jokeGenerator.Model.Player;
import za.co.bbd.jokeGenerator.Model.PunchLine;

public class JokeGeneratorExample {
    public static void main(String[] args) {
        // Joke jk = new Joke();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player"));
        players.add(new Player("AI"));            //we're creating 2 players 

        List<PunchLine> punchlines = new ArrayList<>();
        punchlines.add(new PunchLine(10," "));
        punchlines.add(new PunchLine(4," "));
        punchlines.add(new PunchLine(2," "));
        punchlines.add(new PunchLine(19," "));

        JokeGeneratorAlgorithm jga = new JokeGeneratorAlgorithm(punchlines, players);

        // Player input
        jga.pickPunchline(punchlines.get(0));
        jga.endTurn();   //we could use endTurn as a helper function inside pickPunchline (would that be better though ? )

        // Random AI decision
        jga.pickPunchline(punchlines.get(1));
        jga.endTurn();

        //...
        jga.pickPunchline(punchlines.get(2));
        jga.endTurn();
        jga.pickPunchline(punchlines.get(3));
        jga.endTurn();

        for (Player player : jga.getLeaderboard()) {
            System.out.println(player);
        }
    }
}
