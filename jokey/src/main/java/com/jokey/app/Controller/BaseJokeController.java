package com.jokey.app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jokey.app.Model.BaseJoke;

@Controller
public class BaseJokeController{

    @ModelAttribute ("BaseJokes")
    public BaseJoke GetBaseJoke(){
        //service randomly choose and return base joke
        BaseJoke baseJoke = new BaseJoke();
        return baseJoke;
    }

}