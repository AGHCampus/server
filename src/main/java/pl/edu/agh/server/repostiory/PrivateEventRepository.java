package pl.edu.agh.server.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.PrivateEvent;

import java.util.List;

public interface PrivateEventRepository extends JpaRepository<PrivateEvent, Long> {
    List<PrivateEvent> findAllByOrderByStartDateAsc();
}
