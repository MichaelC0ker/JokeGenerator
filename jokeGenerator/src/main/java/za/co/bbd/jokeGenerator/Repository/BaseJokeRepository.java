package za.co.bbd.jokeGenerator.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.jokeGenerator.Model.BaseJoke;

interface BaseJokeRepository extends JpaRepository<BaseJoke, Integer> {
    BaseJoke findbyId(int id);
}