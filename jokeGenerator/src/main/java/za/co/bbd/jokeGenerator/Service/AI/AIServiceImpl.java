package za.co.bbd.jokeGenerator.Service.AI;

import org.springframework.beans.factory.annotation.Autowired;
import za.co.bbd.jokeGenerator.Model.AIAlgorithm;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.Enum.EDifficulty;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Service.BaseJoke.BaseJokeServiceImpl;
import za.co.bbd.jokeGenerator.Service.PunchLine.PunchLineServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIServiceImpl implements IAIService{
    AIAlgorithm aiAlgorithm = new AIAlgorithm();
    Random random = new Random();
    @Autowired
    private BaseJokeServiceImpl baseJokeService;
    @Autowired
    private PunchLineServiceImpl punchLineService;
    @Override
    public void initializeAI(EDifficulty eDifficulty) {
        aiAlgorithm.setDifficulty(eDifficulty);
    }

    @Override
    public BaseJoke chooseBaseJoke() {
        //randomly choose a base joke from db

        int randomId = random.nextInt(10 - 1 + 1) + 1;
//        BaseJoke baseJoke = baseJokeService.getBaseJokeById(randomId);
        BaseJoke baseJoke = new BaseJoke();
        return baseJoke;
    }

    @Override
    public List<PunchLine> choosePunchLine() {
        //randomly choose a number of punchlines
        List<PunchLine> punchlines = new ArrayList<>();
        punchlines.add(new PunchLine(1,"dum dum tish"));
        punchlines.add(new PunchLine(4,"dum dum toosh"));
//        for(int a = 0; a <= 4; a++){
//            int randomId = random.nextInt(10 - 1 + 1) + 1;
//            punchlines.add(punchLineService.getPunchLineById(randomId));
//        }
        return punchlines;
    }
}
