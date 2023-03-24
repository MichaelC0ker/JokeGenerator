package za.co.bbd.jokeGenerator.Service.JokeGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.jokeGenerator.Model.Player;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Model.JokeGeneratorAlgorithm;
import za.co.bbd.jokeGenerator.Service.PunchLine.PunchLineServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JokeGeneratorAlgorithmService implements IJokeGeneratorAlgorithmService{
    JokeGeneratorAlgorithm jga = new JokeGeneratorAlgorithm();
    @Autowired
    PunchLineServiceImpl punchLineService;
    @Override
    public void initlializeJokeGeneratorAlgorithm(List<Player> players, List<PunchLine> punchlines) {
        jga.setPlayers(players);
        jga.setPunchLines(punchlines);
    }

    @Override
    public PunchLine choosePunchLine(int id) {
        PunchLine punchline = punchLineService.getPunchLineById(id);
        Player currentPlayer = jga.getCurrentPlayer();
        currentPlayer.increaseScore(punchline.getScore());
        endTurn();
        return punchline;
    }

    public List<PunchLine> AiOptions(PunchLine punchLine){
        List<PunchLine> aiPunchLines = new ArrayList<>(jga.getPunchLines());
        aiPunchLines.remove(punchLine);
        return aiPunchLines;
    }

    public void endTurn() {
        jga.setCurrentPlayerVal((jga.getCurrentPlayerVal() + 1) % jga.getPlayers().size());
    }

    public List<Player> getLeaderboard() {
        return jga.getPlayers().stream().sorted(compareByScore).collect(Collectors.toList());
    }
    private final Comparator<Player> compareByScore = Comparator.comparing(Player::getAccumulatedScore).reversed();
}
