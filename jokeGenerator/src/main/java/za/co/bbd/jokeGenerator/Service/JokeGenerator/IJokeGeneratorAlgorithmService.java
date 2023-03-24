package za.co.bbd.jokeGenerator.Service.JokeGenerator;

import za.co.bbd.jokeGenerator.Model.Player;
import za.co.bbd.jokeGenerator.Model.PunchLine;

import java.util.List;

public interface IJokeGeneratorAlgorithmService {
    public void initlializeJokeGeneratorAlgorithm(List<Player> players, List<PunchLine> punchlines);
    public PunchLine choosePunchLine(int id);
    public void endTurn();

}
