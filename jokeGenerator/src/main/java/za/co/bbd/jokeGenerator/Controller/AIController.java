package za.co.bbd.jokeGenerator.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
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
    private List<Player> players = new ArrayList<>();

    public AIController() {
        players.add( new Player("Player"));
        players.add( new Player("AI"));
    }

    @Autowired
    private JokeGeneratorAlgorithmService jokeGeneratorAlgorithmService;
    @Autowired
    private AIServiceImpl aiService;

    @PostMapping("/HomeScreen")
    public String ChooseDifficulty(Model model){
        //initalize ai
        aiService.initializeAI(EDifficulty.EASY);
        return "home";
    }
    @GetMapping("/")
    public String GetAllJokes(Model model){
        //service randomly choose and return base joke
        //maybe set this in constructor jga

        //get random base joke and punchline
        BaseJoke baseJoke = aiService.chooseBaseJoke();
        List<PunchLine> punchLines = aiService.choosePunchLines();
        jokeGeneratorAlgorithmService.initlializeJokeGeneratorAlgorithm(players, punchLines);

        //send to thymeleaf
        model.addAttribute ("basejoke",baseJoke);
        model.addAttribute("punchlines", punchLines);
        model.addAttribute("players", players);
        return "home";
    }
    @PostMapping("/punchlines/pick")
    @ResponseBody
    public RedirectView ChoosePunchLine(@RequestParam int id){
       //player chooses punchline / get id from param
        PunchLine playerPunchLine = jokeGeneratorAlgorithmService.choosePunchLine(id);
        PunchLine aiPunchLine = aiService.SelectSinglePunchLine(jokeGeneratorAlgorithmService.AiOptions(playerPunchLine));
        //ai chooses punchline
        jokeGeneratorAlgorithmService.choosePunchLine(aiPunchLine.getPunchLineid());
        return new RedirectView("/");
    }

}