package za.co.bbd.jokeGenerator;

import java.util.ArrayList;
import java.util.List;

public class Joke {
    private List<Punchline> punchlines = new ArrayList<>();
    private String baseJoke;

    public Joke(String dbData) {
        baseJoke = dbData;
    }
}
