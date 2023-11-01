package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.repostiory.OfferRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;

    public List<Offer> getAllOffers() {
        return offerRepository.findAllByOrderByStartDateAsc();
    }

    public List<Offer> getLocationOffers(long id) {
        return offerRepository.findByLocationIdOrderByStartDateAsc(id);
    }
}
