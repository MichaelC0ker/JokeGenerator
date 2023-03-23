//package za.co.bbd.jokeGenerator.Service;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import za.co.bbd.jokeGenerator.Model.EDifficulty;
//import za.co.bbd.jokeGenerator.Model.PunchLine;
//
//public class AIAlgorithm {
//    private final EDifficulty difficulty;
//    private final Comparator<PunchLine> compareByScore = Comparator
//            .comparing(PunchLine::getScore).reversed();
//
//    public AIAlgorithm(EDifficulty difficulty) {
//        this.difficulty = difficulty;
//    }
//
//    public PunchLine choosePunchline(List<PunchLine> punchlines) {
//        List<PunchLine> sortedPunchlines = punchlines.stream().sorted(compareByScore)
//                .collect(Collectors.toList());
//
//        switch(difficulty) {
//            case EDifficulty.EASY:
//                sortedPunchlines.remove(0);
//                break;
//            case EDifficulty.INSANE:
//                sortedPunchlines.remove(punchlines.size() - 2);
//            case EDifficulty.HARD:
//                sortedPunchlines.remove(punchlines.size() - 1);
//                break;
//            case EDifficulty.MEDIUM:
//            default:
//                break;
//        }
//
//        int totalWeights = sortedPunchlines.stream()
//                .map(PunchLine::getScore)
//                .reduce(0, Integer::sum);
//
//        int randomWeight = (int)(Math.random() * (totalWeights + 1));
//
//        for (PunchLine p : sortedPunchlines) {
//            totalWeights -= p.getScore();
//            if (randomWeight >= totalWeights) {
//                return p;
//            }
//        }
//
//        // Should never happen
//        return null;
//    }
//}
