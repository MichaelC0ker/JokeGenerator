package za.co.bbd.jokeGenerator.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.bbd.jokeGenerator.Model.BaseJoke;

import java.util.Optional;
@Repository
public interface BaseJokeRepository extends JpaRepository<BaseJoke, Integer> {
}