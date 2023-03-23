package za.co.bbd.jokeGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AIAlgorithm {
    private final EDifficulty difficulty;
    private final Comparator<Punchline> compareByScore = Comparator
            .comparing(Punchline::getScore).reversed();

    public AIAlgorithm(EDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Punchline choosePunchline(List<Punchline> punchlines) {
        List<Punchline> sortedPunchlines = punchlines.stream().sorted(compareByScore)
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
                .map(Punchline::getScore)
                .reduce(0, Integer::sum);

        int randomWeight = (int)(Math.random() * (totalWeights + 1));

        for (Punchline p : sortedPunchlines) {
            totalWeights -= p.getScore();
            if (randomWeight >= totalWeights) {
                return p;
            }
        }

        // Should never happen
        return null;
    }
}
