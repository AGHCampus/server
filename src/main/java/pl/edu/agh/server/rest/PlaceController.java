package pl.edu.agh.server.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.common.LocationContent;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.model.Place;
import pl.edu.agh.server.model.PlaceDetails;
import pl.edu.agh.server.repostiory.PlaceDetailsRepository;
import pl.edu.agh.server.repostiory.PlaceRepository;

import java.util.List;

@RestController
@RequestMapping("place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceRepository placeRepository;
    private final PlaceDetailsRepository placeDetailsRepository;
    private final EventController eventController;
    private final OfferController offerController;


    @GetMapping(value = "/", produces = "application/json")
    public List<Place> getPlacesList() {
        return placeRepository.findAll();
    }

    @GetMapping(value = "/{id}/details", produces = "application/json")
    public PlaceDetails getPlaceDetails(@PathVariable long id) {
        return placeDetailsRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "/{id}/info", produces = "application/json")
    public LocationContent getAllData(@PathVariable long id) {
        List<Offer> offers = offerController.getPlaceOffers(id);
        List<Event> events = eventController.getPlaceEvents(id);
        PlaceDetails placeDetails = getPlaceDetails(id);

        return new LocationContent(offers, events, placeDetails);
    }
}
