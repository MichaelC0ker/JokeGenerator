package za.co.bbd.jokeGenerator.Service.AI;

import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.Enum.EDifficulty;
import za.co.bbd.jokeGenerator.Model.PunchLine;

import java.util.List;

public interface IAIService {
    public void initializeAI(EDifficulty eDifficulty);
    public BaseJoke chooseBaseJoke();
    public List<PunchLine> choosePunchLines();
    public PunchLine SelectSinglePunchLine(List<PunchLine> punchLines);

}
