package pl.edu.agh.server.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.Information;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
