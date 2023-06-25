package pl.edu.agh.server.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.agh.server.model.PlaceOffer;

import java.util.List;

public interface PlaceOfferRepository extends JpaRepository<PlaceOffer, Long> {
    List<PlaceOffer> findByPlaceId(Long id);
}
