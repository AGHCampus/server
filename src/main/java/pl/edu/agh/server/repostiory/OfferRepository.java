package pl.edu.agh.server.repostiory;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.agh.server.model.Offer;

import java.util.Date;
import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Query("SELECT o FROM Offer o WHERE o.startDate >= :date ORDER BY o.startDate ASC")
    List<Offer> findAllByOrderByStartDateAsc(@Param("date") Date startDate);

    @Query("SELECT o FROM Offer o WHERE o.locationId = :locationId AND o.startDate >= :date ORDER BY o.startDate ASC")
    List<Offer> findByLocationIdOrderByStartDateAsc(@Param("locationId") Long locationId, @Param("date") Date date);

    @Transactional
    void deleteAllByLocationId(Long id);
}
