package za.co.bbd.jokeGenerator.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.Joke;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import za.co.bbd.jokeGenerator.Repository.BaseJokeRepository;
import za.co.bbd.jokeGenerator.Repository.PunchLineRepository;
@Configuration
public class DummyData {

    @Bean
    CommandLineRunner dummy(BaseJokeRepository baseJokeRepository, PunchLineRepository punchLineRepository){

        return args -> {
            Joke jokes = new Joke();
            baseJokeRepository.saveAll(jokes.baseJokes);
            punchLineRepository.saveAll(jokes.punchlines);
        };
    }
}
