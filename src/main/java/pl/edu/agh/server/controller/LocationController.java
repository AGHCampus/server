package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.model.Location;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.common.LocationRequest;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.service.EventService;
import pl.edu.agh.server.service.LocationDetailsService;
import pl.edu.agh.server.service.LocationService;
import pl.edu.agh.server.service.OfferService;

import java.util.List;

@RestController
@RequestMapping("locations")
@RequiredArgsConstructor
@CrossOrigin
public class LocationController {
    private final LocationService locationService;
    private final LocationDetailsService locationDetailsService;
    private final OfferService offerService;
    private final EventService eventService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Location> getLocationList() {
        return locationService.getLocationList();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Location getLocation(@PathVariable long id) {
        return locationService.getLocation(id);
    }

    @GetMapping(value = "/{id}/details", produces = "application/json")
    public LocationDetails getLocationDetails(@PathVariable long id) {
        return locationDetailsService.getLocationDetails(id);
    }

    @GetMapping(value = "/{id}/events", produces = "application/json")
    public List<Event> getLocationEvents(@PathVariable long id) {
        return eventService.getLocationEvents(id);
    }

    @GetMapping(value = "/{id}/offers", produces = "application/json")
    public List<Offer> getLocationOffers(@PathVariable long id) {
        return offerService.getLocationOffers(id);
    }

    @PostMapping(value = "/", produces = "application/json")
    public Location createLocation(@RequestBody LocationRequest locationRequest) {
        return locationService.createLocation(locationRequest);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Location updateLocation(@PathVariable long id, @RequestBody LocationRequest locationRequest) {
        return locationService.updateLocation(id, locationRequest);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Location deleteLocation(@PathVariable long id) {
        return locationService.deleteLocation(id);
    }
}
