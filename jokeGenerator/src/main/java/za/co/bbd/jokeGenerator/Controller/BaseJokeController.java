package za.co.bbd.jokeGenerator.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.bbd.jokeGenerator.Service.BaseJoke.BaseJokeServiceImpl;
import za.co.bbd.jokeGenerator.Service.PunchLine.PunchLineServiceImpl;


@Controller
public class BaseJokeController{
    @Autowired
    private BaseJokeServiceImpl baseJokeService;

    @Autowired
    private PunchLineServiceImpl punchLineService;

    @GetMapping("/")
    public String GetBaseJoke(Model model){
        //service randomly choose and return base joke
        model.addAttribute ("basejoke",baseJokeService.getBaseJoke());
        model.addAttribute("punchlines", punchLineService.getPunchLines());
        return "home";
    }

}