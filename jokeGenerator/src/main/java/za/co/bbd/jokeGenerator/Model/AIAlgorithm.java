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
    public EDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(EDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}
