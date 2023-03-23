package za.co.bbd.jokeGenerator.Service.JokeGenerator;

import za.co.bbd.jokeGenerator.Model.Player;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Model.JokeGeneratorAlgorithm;
import za.co.bbd.jokeGenerator.Service.PunchLine.PunchLineServiceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JokeGeneratorAlgorithmService implements IJokeGeneratorAlgorithmService{
    JokeGeneratorAlgorithm jga = new JokeGeneratorAlgorithm();
    PunchLineServiceImpl punchLineService = new PunchLineServiceImpl();
    @Override
    public void initlializeJokeGeneratorAlgorithm(List<Player> players, List<PunchLine> punchlines) {
        jga.setPlayers(players);
        jga.setPunchLines(punchlines);
    }

    @Override
    public Integer choosePunchLine(int id) {
        //gets score of chosen punchline and adds it to players score
        PunchLine punchline = punchLineService.getPunchLineById(id);
        Player currentPlayer = jga.getCurrentPlayer();
        currentPlayer.increaseScore(punchline.getScore());
        endTurn();
        return currentPlayer.getAccumulatedScore();
    }


    public void endTurn() {
        //ends turn by switches players
        jga.setCurrentPlayerVal((jga.getCurrentPlayerVal() + 1) % jga.getPlayers().size());
    }

    public List<Player> getLeaderboard() {
        //gets current scores for all players
        return jga.getPlayers().stream().sorted(compareByScore).collect(Collectors.toList());  //Michael wants to know more about this :-)
    }
    private final Comparator<Player> compareByScore = Comparator.comparing(Player::getAccumulatedScore).reversed();
}
