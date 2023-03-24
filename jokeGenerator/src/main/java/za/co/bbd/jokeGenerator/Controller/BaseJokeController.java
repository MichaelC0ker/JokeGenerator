package za.co.bbd.jokeGenerator.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.Player;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Service.AI.AIServiceImpl;
import za.co.bbd.jokeGenerator.Service.BaseJoke.BaseJokeServiceImpl;
import za.co.bbd.jokeGenerator.Service.JokeGenerator.JokeGeneratorAlgorithmService;
import za.co.bbd.jokeGenerator.Service.PunchLine.PunchLineServiceImpl;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BaseJokeController{
    private JokeGeneratorAlgorithmService jokeGeneratorAlgorithmService;
    private AIServiceImpl aiService;
//    @GetMapping("/game")
//    public String GetAllJokes(Model model){
//        //service randomly choose and return base joke
//        List<Player> players = new ArrayList<>();
//        players.add( new Player("Player"));
//        players.add( new Player("AI"));
//
//        //joke generator algorithm
//        BaseJoke baseJoke = aiService.chooseBaseJoke();
//        List<PunchLine> punchLines = aiService.choosePunchLines();
//        jokeGeneratorAlgorithmService.initlializeJokeGeneratorAlgorithm(players, punchLines);
//
//        //send to thymeleaf
//        model.addAttribute ("basejoke",baseJoke);
//        model.addAttribute("punchlines", punchLines);
//        return "home";
//    }

}