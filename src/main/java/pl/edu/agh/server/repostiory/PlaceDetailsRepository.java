package pl.edu.agh.server.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.PlaceDetails;

public interface PlaceDetailsRepository extends JpaRepository<PlaceDetails, Long> {
}
