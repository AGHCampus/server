package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.common.requests.OfferRequest;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.repostiory.OfferRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferService {
    private static final String NOT_FOUND_MESSAGE = "Offer not found with id: ";
    private final OfferRepository offerRepository;

    public List<Offer> getOffersList(Optional<Long> locationId, String language) {
        List<Offer> offers;
        if (locationId.isPresent()) {
            offers = offerRepository.findByLocationIdOrderByStartDateAsc(locationId.get());
        } else {
            offers = offerRepository.findAllByOrderByStartDateAsc();
        }

        offers.forEach(offer -> offer.setDescription(language));

        return offers;
    }

    public Offer getOffer(long id, String language) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        offer.setDescription(language);

        return offer;
    }

    public Offer createOffer(OfferRequest offerRequest) {
        Offer offer = new Offer();
        offer.updateFromRequest(offerRequest);

        return offerRepository.saveAndFlush(offer);
    }

    public Offer updateOffer(long id, OfferRequest offerDetails) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        offer.updateFromRequest(offerDetails);

        return offerRepository.saveAndFlush(offer);
    }

    public Offer deleteOffer(long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        offerRepository.deleteById(id);

        return offer;
    }
}
