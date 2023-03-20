package za.co.bbd.jokeGenerator;

import java.util.ArrayList;
import java.util.List;

public class JokeGeneratorExample {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player"));
        players.add(new Player("AI"));

        List<Punchline> punchlines = new ArrayList<>();
        punchlines.add(new Punchline(10));
        punchlines.add(new Punchline(4));
        punchlines.add(new Punchline(2));
        punchlines.add(new Punchline(19));

        JokeGeneratorAlgorithm jga = new JokeGeneratorAlgorithm(punchlines, players);

        // Player input
        jga.pickPunchline(punchlines.get(0));
        jga.endTurn();

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