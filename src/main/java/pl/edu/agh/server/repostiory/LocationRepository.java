package pl.edu.agh.server.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
