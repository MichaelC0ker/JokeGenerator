package za.co.bbd.jokeGenerator.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import za.co.bbd.jokeGenerator.Model.Enum.EDifficulty;
import za.co.bbd.jokeGenerator.Model.Player;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Service.AI.AIServiceImpl;
import za.co.bbd.jokeGenerator.Service.BaseJoke.BaseJokeServiceImpl;
import za.co.bbd.jokeGenerator.Service.JokeGenerator.JokeGeneratorAlgorithmService;
import za.co.bbd.jokeGenerator.Service.PunchLine.PunchLineServiceImpl;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AIController{
    @Autowired
    private JokeGeneratorAlgorithmService jokeGeneratorAlgorithmService;
    @Autowired
    private AIServiceImpl aiService;
    @PostMapping("/HomeScreen")
    public String ChooseDifficulty(Model model){
        //initalize ai and joke generator algorithm
        List<Player> players = new ArrayList<>();
        players.add( new Player("Player"));
        players.add( new Player("AI"));

        aiService.initializeAI(EDifficulty.EASY);

        List<PunchLine> punchLines = aiService.choosePunchLine();
        jokeGeneratorAlgorithmService.initlializeJokeGeneratorAlgorithm(players, punchLines);

        return "home";
    }
}