package za.co.bbd.jokeGenerator.Service.BaseJoke;
import za.co.bbd.jokeGenerator.Model.BaseJoke;

public interface IBaseJokeService {
    public BaseJoke getBaseJokeById(int id);
    public int getNumJokes();
}
