package pl.edu.agh.server.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.Information;

import java.util.List;

public interface InformationRepository extends JpaRepository<Information, Long> {
    List<Information> findAllByOrderByTimestampDesc();
}
