package pl.edu.agh.server.repostiory;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.Offer;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findAllByOrderByStartDateAsc();

    List<Offer> findByLocationIdOrderByStartDateAsc(Long id);

    @Transactional
    void deleteAllByLocationId(Long id);
}
