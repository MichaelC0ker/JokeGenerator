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
    @Autowired
    private BaseJokeRepository baseJokeRepository;
    @Override
    public int getNumJokes(){ return (int)baseJokeRepository.count(); }
    @Override
    public BaseJoke getBaseJokeById(int id) {
        return baseJokeRepository.findById(id).orElse(new BaseJoke());
    }

}
