package za.co.bbd.jokeGenerator.Repository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.bbd.jokeGenerator.Model.BaseJoke;
import za.co.bbd.jokeGenerator.Model.PunchLine;
import java.util.List;
import java.util.Optional;
@Repository
public interface BaseJokeRepository extends JpaRepository<BaseJoke, Integer> {
    List<BaseJoke> findAll();

    long count();
    Optional<BaseJoke> findById(int baseJokeId);

}