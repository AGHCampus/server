package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.common.requests.LocationRequest;
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

    @GetMapping(value = "", produces = "application/json")
    public List<Location> getLocationList(@RequestParam String lang) {
        return locationService.getLocationList(lang);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Location getLocation(@PathVariable long id, @RequestParam String lang) {
        return locationService.getLocation(id, lang);
    }

    @GetMapping(value = "/{id}/details", produces = "application/json")
    public LocationDetails getLocationDetails(@PathVariable long id, @RequestParam String lang) {
        return locationDetailsService.getLocationDetails(id, lang);
    }

    @PostMapping(value = "", produces = "application/json")
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
