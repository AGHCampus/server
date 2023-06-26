package pl.edu.agh.server.repostiory;

import pl.edu.agh.server.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
