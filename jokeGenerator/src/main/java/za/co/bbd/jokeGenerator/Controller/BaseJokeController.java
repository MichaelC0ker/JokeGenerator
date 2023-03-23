package za.co.bbd.jokeGenerator.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Service.BaseJoke.BaseJokeService;


@Controller
public class BaseJokeController{
    @Autowired
    private BaseJokeService service;

    @ModelAttribute ("BaseJokes")
    public BaseJoke GetBaseJoke(){
        //service randomly choose and return base joke
        return service.getBaseJoke();
    }

}