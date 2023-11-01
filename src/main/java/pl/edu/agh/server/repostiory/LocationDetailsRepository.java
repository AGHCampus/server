package pl.edu.agh.server.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.LocationDetails;

public interface LocationDetailsRepository extends JpaRepository<LocationDetails, Long> {
}
