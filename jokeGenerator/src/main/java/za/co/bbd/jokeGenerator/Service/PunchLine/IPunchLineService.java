package za.co.bbd.jokeGenerator.Service.PunchLine;

import java.util.List;

import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Model.Rating;

public interface IPunchLineService {
    public abstract List<PunchLine> getAllPunchLines();
    public abstract PunchLine getPunchLineById(int Id);
}
