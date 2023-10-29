package pl.edu.agh.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.model.Location;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.repostiory.LocationRepository;
import pl.edu.agh.server.service.common.Coordinate;
import pl.edu.agh.server.service.common.LocationContent;

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
        List<Location> locations = locationRepository.findAll();

        locations.forEach(location -> location.setCoordinate(new Coordinate(location.getLongitude(), location.getLatitude())));

        return locations;
    }

    public LocationContent getLocationContent(@PathVariable long id) {
        List<Offer> offers = offerService.getLocationOffers(id);
        List<Event> events = eventService.getLocationEvents(id);
        LocationDetails locationDetails = locationDetailsService.getLocationDetails(id);

        return new LocationContent(offers, events, locationDetails);
    }
}
