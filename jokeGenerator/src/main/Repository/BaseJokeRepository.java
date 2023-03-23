package za.co.bbd.jokeGenerator.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.jokeGenerator.Model.BaseJoke;

import java.util.Optional;

interface BaseJokeRepository extends JpaRepository<BaseJoke, Integer> {
    @Override
    Optional<BaseJoke> findById(Integer integer);
}