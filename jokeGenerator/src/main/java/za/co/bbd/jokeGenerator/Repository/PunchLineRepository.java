package za.co.bbd.jokeGenerator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.bbd.jokeGenerator.Model.PunchLine;

import java.util.List;
import java.util.Optional;
@Repository
public interface PunchLineRepository extends JpaRepository<PunchLine, Integer> {

    Optional<PunchLine> findById(int punchLineid);
}