package za.co.bbd.jokeGenerator.Service.BaseJoke;
import java.util.Optional;
import java.util.Random;

//import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Repository.BaseJokeRepository;

@Service
public class BaseJokeServiceImpl implements IBaseJokeService {
    //private final BaseJokeRepository repository;
    @Autowired
    private BaseJokeRepository baseJokeRepository;
    @Override
    public int getNumJokes(){
        return (int)baseJokeRepository.count();  //convert long to int for nextInt
    }
    @Override
    public BaseJoke getBaseJokeById(int id) {
        Random random = new Random();
        int randomId = random.nextInt((int) getNumJokes() - 1 + 1) + 1;

        // BaseJoke baseJoke = new BaseJoke(1,"basejoke");
        Optional<BaseJoke> bj = baseJokeRepository.findById(id);

//        return bj.orElseThrow(() -> new EntityNotFoundException("Entity not found with id " + id + "Not found"));
        //should generate a new number and get again
        return bj.orElse(new BaseJoke());

    }

}
