package pl.edu.agh.server.repostiory;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByOrderByStartDateAsc();

    List<Event> findByLocationIdOrderByStartDateAsc(Long id);

    @Transactional
    void deleteAllByLocationId(Long id);
}
