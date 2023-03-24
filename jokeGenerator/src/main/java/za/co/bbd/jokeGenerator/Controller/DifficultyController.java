package za.co.bbd.jokeGenerator.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.bbd.jokeGenerator.Model.Enum.EDifficulty;


@Controller
public class DifficultyController{

//    @GetMapping("/")
//    public String GetDifficulties(Model model){
//        //service randomly choose and return base joke
//        model.addAttribute("difficulties", EDifficulty.values());
//        return "landing";
//    }

}