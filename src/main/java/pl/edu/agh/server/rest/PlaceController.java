package pl.edu.agh.server.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.model.Place;
import pl.edu.agh.server.model.PlaceDetails;
import pl.edu.agh.server.model.PlaceOffer;
import pl.edu.agh.server.repostiory.PlaceDetailsRepository;
import pl.edu.agh.server.repostiory.PlaceOfferRepository;
import pl.edu.agh.server.repostiory.PlaceRepository;

import java.util.List;

@RestController
@RequestMapping("place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceRepository placeRepository;
    private final PlaceDetailsRepository placeDetailsRepository;
    private final PlaceOfferRepository placeOfferRepository;

    @GetMapping(value = "/", produces = "application/json")
    public List<Place> getPlaceList() {
        return placeRepository.findAll();
    }

    @GetMapping(value = "/{id}/details", produces = "application/json")
    public PlaceDetails getPlaceDetails(@PathVariable long id) {
        return placeDetailsRepository.getReferenceById(id);
    }

    @GetMapping(value = "/{id}/offers", produces = "application/json")
    public List<PlaceOffer> getOffersList(@PathVariable long id) {
        return placeOfferRepository.findByPlaceId(id);
    }
}
