package za.co.bbd.jokeGenerator.Service.BaseJoke;
import java.util.Optional;
import java.util.Random;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Repository.BaseJokeRepository;

@Service
public class BaseJokeServiceImpl extends IBaseJokeService {
    //private final BaseJokeRepository repository;
    private BaseJokeRepository bjRep;

    private int getNumJokes(){
        return (int)bjRep.count();  //convert long to int for nextInt
    }
    @Override
    public BaseJoke getBaseJoke() {
        Random random = new Random();
        int randomId = random.nextInt((int)getNumJokes() - 1 + 1) + 1;

       // BaseJoke baseJoke = new BaseJoke(1,"basejoke");
        Optional<BaseJoke> bj = bjRep.findById(randomId);

        return bj.orElseThrow(() -> new EntityNotFoundException("Entity not found with id " + randomId + "Not found"));
    }


} 
