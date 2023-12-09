package pl.edu.agh.server.repostiory;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.agh.server.model.Event;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.startDate >= :date ORDER BY e.startDate ASC")
    List<Event> findAllByOrderByStartDateAsc(@Param("date") Date date);

    @Query("SELECT e FROM Event e WHERE e.locationId = :locationId AND e.startDate >= :date ORDER BY e.startDate ASC")
    List<Event> findByLocationIdOrderByStartDateAsc(@Param("locationId") Long locationId, @Param("date") Date date);

    List<Event> findAllByOrderByStartDateDesc();

    List<Event> findAllByLocationIdInOrderByStartDateDesc(Collection<Long> locationId);

    @Transactional
    void deleteAllByLocationId(Long id);
}
