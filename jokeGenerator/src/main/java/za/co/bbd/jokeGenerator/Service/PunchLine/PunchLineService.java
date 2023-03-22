package za.co.bbd.jokeGenerator.Service.PunchLine;

import java.util.List;

import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Model.Rating;

public interface PunchLineService {
    public abstract List<PunchLine> getPunchLines();
    public abstract Rating submitPunchLine(List<PunchLine> punchlines, BaseJoke baseJoke);
}
