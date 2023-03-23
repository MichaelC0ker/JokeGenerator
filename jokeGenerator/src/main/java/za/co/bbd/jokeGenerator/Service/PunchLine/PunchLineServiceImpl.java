package za.co.bbd.jokeGenerator.Service.PunchLine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Model.Rating;
@Service
public class PunchLineServiceImpl implements IPunchLineService {
    List<PunchLine> punchlines = new ArrayList<>();

    @Override
    public List<PunchLine> getPunchLines() {
        //will most likley delete
        punchlines.add(new PunchLine(1,"dum dum tish"));
        return punchlines;
    }

    @Override
    public Rating submitPunchLine(List<PunchLine> punchlines, BaseJoke baseJoke) {
        //will use algorithm here most likely to return rating
        //will most likley delete
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'submitPunchLine'");
    }

    @Override
    public PunchLine getPunchLineById(int Id) {
        //get from db
        return punchlines.get(0);
    }

}
