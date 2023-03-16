package com.jokey.app.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.jokey.app.Model.PunchLine;
import com.jokey.app.Model.Rating;

@Controller
public class PunchlineController{

    @GetMapping("/punchLine")
    public List<PunchLine> GetPunchLine(){
        //service randomly chooses 4 Punchline adds it to a list and returns the list of punchlines
        List<PunchLine> punchlines = new ArrayList<>();
        return punchlines;
    }

    @PostMapping("/punchLine")
    public Rating SubmitPunchLine(){
        //service take base joke and list of punclines, check which rating has the highest score and return that rating
        Rating rating = new Rating();
        return rating;
    }

}