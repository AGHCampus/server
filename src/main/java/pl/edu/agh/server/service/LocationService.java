package pl.edu.agh.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.agh.server.common.LocationContent;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.model.Location;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.repostiory.LocationRepository;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private OfferService offerService;

    @Autowired
    private EventService eventService;

    @Autowired
    private LocationDetailsService locationDetailsService;

    public List<Location> getLocationList() {
        return locationRepository.findAll();
    }

    public LocationContent getAllData(@PathVariable long id) {
        List<Offer> offers = offerService.getLocationOffers(id);
        List<Event> events = eventService.getLocationEvents(id);
        LocationDetails locationDetails = locationDetailsService.getLocationDetails(id);

        return new LocationContent(offers, events, locationDetails);
    }
}
