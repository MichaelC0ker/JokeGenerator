package za.co.bbd.jokeGenerator.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Model.Rating;
import za.co.bbd.jokeGenerator.Service.PunchLine.PunchLineServiceImpl;

@Controller
public class PunchlineController{
    @Autowired
    private PunchLineServiceImpl punchLineService;
//    @GetMapping("/punchlines")
//    public String GetPunchLines(Model model){
//        //service randomly chooses 4 Punchline adds it to a list and returns the list of punchlines
//        model.addAttribute ("punchlines", punchLineService.getPunchLines());
//        return "punchlines";
//    }

    @PostMapping("/rating")
    public String SubmitPunchLine(Model model){
        //service take base joke and list of punclines, check which rating has the highest score and return that rating
        List<PunchLine> punchlines = new ArrayList<>();
        BaseJoke baseJoke = new BaseJoke();
        model.addAttribute("rating",punchLineService.submitPunchLine(punchlines, baseJoke));
        return "rating";
    }

}