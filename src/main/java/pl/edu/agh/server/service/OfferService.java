package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.common.requests.OfferRequest;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.repostiory.OfferRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OfferService {
    private static final String NOT_FOUND_MESSAGE = "Offer not found with id: ";
    private final OfferRepository offerRepository;
    private final CurrentUserService currentUserService;

    public List<Offer> getTranslatedOffersList(Optional<Long> locationId, String language) {
        List<Offer> offers;
        Date date = new Date();
        if (locationId.isPresent()) {
            offers = offerRepository.findByLocationIdOrderByStartDateAsc(locationId.get(), date);
        } else {
            offers = offerRepository.findAllByOrderByStartDateAsc(date);
        }

        offers.forEach(offer -> {
            offer.setDescription(language);
            offer.setDescriptionTranslations(null);
        });

        return offers;
    }

    public List<Offer> getOffersList() {
        if (currentUserService.hasAdminPermissions()) {
            return offerRepository.findAllByOrderByStartDateDesc();
        }

        Set<Long> locationIds = currentUserService.getLocationIds();
        return offerRepository.findAllByLocationIdInOrderByStartDateDesc(locationIds);
    }

    public Offer getTranslatedOffer(long id, String language) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        offer.setDescription(language);
        offer.setDescriptionTranslations(null);

        return offer;
    }

    public Offer getOffer(long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        if (currentUserService.isUnauthorizedForLocation(offer.getLocationId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

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

        if (currentUserService.isUnauthorizedForLocation(offer.getLocationId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        offer.updateFromRequest(offerDetails);

        return offerRepository.saveAndFlush(offer);
    }

    public Offer deleteOffer(long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        if (currentUserService.isUnauthorizedForLocation(offer.getLocationId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        offerRepository.deleteById(id);

        return offer;
    }
}
