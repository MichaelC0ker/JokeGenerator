package za.co.bbd.jokeGenerator.Service.PunchLine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Model.Rating;
@Service
public class PunchLineServiceImpl implements IPunchLineService {

    @Override
    public List<PunchLine> getPunchLines() {
        List<PunchLine> punchlines = new ArrayList<>();
        punchlines.add(new PunchLine(1,"dum dum tish"));
        punchlines.add(new PunchLine(5,"ba dum tish"));
        punchlines.add(new PunchLine(4,"Only TWO!"));
        punchlines.add(new PunchLine(3,"Fifteen at least"));
        punchlines.add(new PunchLine(2,"The right amount"));
        return punchlines;
    }

    @Override
    public Rating submitPunchLine(List<PunchLine> punchlines, BaseJoke baseJoke) {
        //will use algorithm here most likely to return rating
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'submitPunchLine'");
    }
    
}
