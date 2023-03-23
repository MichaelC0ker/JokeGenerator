package za.co.bbd.jokeGenerator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.jokeGenerator.Model.PunchLine;

import java.util.Optional;

public interface PunchLineRepository extends JpaRepository<PunchLine, Integer> {
    @Override
    Optional<PunchLine> findById(Integer integer);
}