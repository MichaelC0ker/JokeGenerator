package za.co.bbd.jokeGenerator.Service.BaseJoke;
import java.util.Random;

import org.springframework.stereotype.Service;
import za.co.bbd.jokeGenerator.Model.BaseJoke;

@Service
public class BaseJokeServiceImpl extends IBaseJokeService {
    //private final BaseJokeRepository repository;

    @Override
    public BaseJoke getBaseJoke() {
        Random random = new Random();
        int randomId = random.nextInt(10 - 1 + 1) + 1;
        
        BaseJoke baseJoke = new BaseJoke(1,"basejoke");

        return baseJoke;
        //would use repository to get basejoke by id
        //return repository.findById(randomId);
    }
} 
