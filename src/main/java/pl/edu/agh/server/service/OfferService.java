package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.repostiory.OfferRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {
    private static final String NOT_FOUND_MESSAGE = "Offer not found with id: ";
    private final OfferRepository offerRepository;

    public List<Offer> getOffersList() {
        return offerRepository.findAllByOrderByStartDateAsc();
    }

    public Offer getOffer(long id) {
        return offerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );
    }

    public Offer createOffer(Offer offer) {
        return offerRepository.saveAndFlush(offer);
    }

    public Offer updateOffer(long id, Offer offerDetails) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        offer.setLocationId(offerDetails.getLocationId());
        offer.setDescription(offerDetails.getDescription());
        offer.setStartDate(offerDetails.getStartDate());
        offer.setEndDate(offerDetails.getEndDate());
        offer.setWebsiteUrl(offerDetails.getWebsiteUrl());
        offer.setImageUrl(offerDetails.getImageUrl());

        return offerRepository.saveAndFlush(offer);
    }

    public Offer deleteOffer(long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        offerRepository.deleteById(id);

        return offer;
    }

    public List<Offer> getLocationOffers(long id) {
        return offerRepository.findByLocationIdOrderByStartDateAsc(id);
    }
}
