package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.model.Location;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.service.LocationDetailsService;
import pl.edu.agh.server.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    private final LocationDetailsService locationDetailsService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Location> getLocationList() {
        return locationService.getLocationList();
    }

    @GetMapping(value = "/{id}/details", produces = "application/json")
    public LocationDetails getLocationDetails(@PathVariable long id) {
        return locationDetailsService.getLocationDetails(id);
    }
}
