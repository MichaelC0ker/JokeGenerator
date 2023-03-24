package za.co.bbd.jokeGenerator.Service.AI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.jokeGenerator.Model.AIAlgorithm;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.Enum.EDifficulty;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Service.BaseJoke.BaseJokeServiceImpl;
import za.co.bbd.jokeGenerator.Service.PunchLine.PunchLineServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AIServiceImpl implements IAIService{
    AIAlgorithm aiAlgorithm = new AIAlgorithm();

    Random random = new Random();
    @Autowired
    private BaseJokeServiceImpl baseJokeService;
    @Autowired
    private PunchLineServiceImpl punchLineService;
    @Override
    public void initializeAI(EDifficulty eDifficulty) {
        aiAlgorithm.setDifficulty(eDifficulty);
    }

    @Override
    public BaseJoke chooseBaseJoke() {
        //randomly choose a base joke from db
        Random random = new Random();
        int numOfJokes = baseJokeService.getNumJokes();
        int randomId = random.nextInt((int) numOfJokes - 1 + 1) + 1;

        return baseJokeService.getBaseJokeById(randomId);
    }

    @Override
    public List<PunchLine> choosePunchLines(int winningPunchline) {
        //randomly choose a number of punchlines
        List<PunchLine> punchlines = punchLineService.getAllPunchLines();
        List<PunchLine> results = new ArrayList<>();
        for (int i=0; i<4; i++) {
            results.add(punchlines.get(random.nextInt(punchlines.size())));
        }
        results.add(punchLineService.getPunchLineById( winningPunchline));
        return results;
    }

    @Override
    public PunchLine SelectSinglePunchLine(List<PunchLine> punchLines){

        List<PunchLine> sortedPunchlines = punchLines.stream().sorted(compareByScore)
                .collect(Collectors.toList());

        switch(aiAlgorithm.getDifficulty()) {
            case EASY:
                sortedPunchlines.remove(0);
                break;
            case INSANE:
                sortedPunchlines.remove(punchLines.size() - 2);
            case HARD:
                sortedPunchlines.remove(punchLines.size() - 1);
                break;
            case MEDIUM:
            default:
                break;
        }

        int totalWeights = sortedPunchlines.stream()
                .map(PunchLine::getScore)
                .reduce(0, Integer::sum);

        int randomWeight = (int)(Math.random() * (totalWeights + 1));

        for (PunchLine p : sortedPunchlines) {
            totalWeights -= p.getScore();
            if (randomWeight >= totalWeights) {
                return p;
            }
        }

        // Should never happen
        return null;    }

    private final Comparator<PunchLine> compareByScore = Comparator
            .comparing(PunchLine::getScore).reversed();
}
