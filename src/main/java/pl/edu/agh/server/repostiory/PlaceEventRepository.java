package pl.edu.agh.server.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.PlaceEvent;

import java.util.List;

public interface PlaceEventRepository extends JpaRepository<PlaceEvent, Long> {
    List<PlaceEvent> findByPlaceId(Long id);
}
