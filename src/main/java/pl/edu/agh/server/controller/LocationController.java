package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.common.LocationContent;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.model.Location;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.repostiory.LocationDetailsRepository;
import pl.edu.agh.server.repostiory.LocationRepository;

import java.util.List;

@RestController
@RequestMapping("location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationRepository LocationRepository;
    private final LocationDetailsRepository LocationDetailsRepository;
    private final EventController eventController;
    private final OfferController offerController;


    @GetMapping(value = "/all", produces = "application/json")
    public List<Location> getLocationList() {
        return LocationRepository.findAll();
    }

    @GetMapping(value = "/{id}/details", produces = "application/json")
    public LocationDetails getLocationDetails(@PathVariable long id) {
        return LocationDetailsRepository.findById(id).orElse(null);
    }

    @GetMapping(value = "/{id}/info", produces = "application/json")
    public LocationContent getAllData(@PathVariable long id) {
        List<Offer> offers = offerController.getLocationOffers(id);
        List<Event> events = eventController.getLocationEvents(id);
        LocationDetails locationDetails = getLocationDetails(id);

        return new LocationContent(offers, events, locationDetails);
    }
}
