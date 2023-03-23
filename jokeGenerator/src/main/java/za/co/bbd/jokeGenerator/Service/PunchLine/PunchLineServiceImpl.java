package za.co.bbd.jokeGenerator.Service.PunchLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Model.Rating;
import za.co.bbd.jokeGenerator.Repository.PunchLineRepository;

@Service
public class PunchLineServiceImpl implements IPunchLineService {

    final private PunchLineRepository repository;
    Random rand = new Random();

    @Autowired
    public PunchLineServiceImpl(PunchLineRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PunchLine> getPunchLines() {
//        List<PunchLine> punchlines = new ArrayList<>();
//        punchlines.add(new PunchLine(1,"dum dum tish"));
//        punchlines.add(new PunchLine(5,"ba dum tish"));
//        punchlines.add(new PunchLine(4,"Only TWO!"));
//        punchlines.add(new PunchLine(3,"Fifteen at least"));
//        punchlines.add(new PunchLine(2,"The right amount"));
//        return punchlines;

        List<PunchLine> punchlines = repository.findAll();
        List<PunchLine> results = new ArrayList<>();

        for (int i=0; i<5; i++) {
            results.add(punchlines.get(rand.nextInt(punchlines.size())));
        }
        return results;
    }

    @Override
    public Rating submitPunchLine(List<PunchLine> punchlines, BaseJoke baseJoke) {
        //will use algorithm here most likely to return rating
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'submitPunchLine'");
    }
    
}
