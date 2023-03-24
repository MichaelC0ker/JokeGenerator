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
    List<PunchLine> punchlines = new ArrayList<>();
    @Autowired
    private PunchLineRepository punchLineRepository;
    Random rand = new Random();
    @Override
    public List<PunchLine> getAllPunchLines() {
        return punchLineRepository.findAll();
    }
    @Override
    public PunchLine getPunchLineById(int id) {
        //get from db
        return punchLineRepository.findById(id).orElse(new PunchLine());
    }

}
