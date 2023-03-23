package za.co.bbd.jokeGenerator.Model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import za.co.bbd.jokeGenerator.Model.Enum.EDifficulty;

public class AIAlgorithm {
    private EDifficulty difficulty;
    public AIAlgorithm(EDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public AIAlgorithm() {
    }
    public PunchLine choosePunchline(List<PunchLine> punchlines) {
        List<PunchLine> sortedPunchlines = punchlines.stream().sorted(compareByScore)
                .collect(Collectors.toList());

        switch(difficulty) {
            case EASY:
                sortedPunchlines.remove(0);
                break;
            case INSANE:
                sortedPunchlines.remove(punchlines.size() - 2);
            case HARD:
                sortedPunchlines.remove(punchlines.size() - 1);
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
        return null;
    }

    public EDifficulty getDifficulty() {
        return difficulty;
    }

    private final Comparator<PunchLine> compareByScore = Comparator
            .comparing(PunchLine::getScore).reversed();
    public void setDifficulty(EDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}
