package pl.edu.agh.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.repostiory.OfferRepository;

import java.util.List;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getAllOffers() {
        return offerRepository.findAllByOrderByStartDateAsc();
    }

    public List<Offer> getLocationOffers(long id) {
        return offerRepository.findByLocationIdOrderByStartDateAsc(id);
    }
}
