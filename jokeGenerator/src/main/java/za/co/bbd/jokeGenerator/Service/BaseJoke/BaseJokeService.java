package za.co.bbd.jokeGenerator.Service.BaseJoke;
import org.springframework.stereotype.Service;
import za.co.bbd.jokeGenerator.Model.BaseJoke;

@Service
public abstract class  BaseJokeService {
    public abstract BaseJoke getBaseJoke();
}
