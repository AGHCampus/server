package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.common.Coordinate;
import pl.edu.agh.server.common.requests.LocationRequest;
import pl.edu.agh.server.model.Location;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.repostiory.EventRepository;
import pl.edu.agh.server.repostiory.LocationDetailsRepository;
import pl.edu.agh.server.repostiory.LocationRepository;
import pl.edu.agh.server.repostiory.OfferRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private static final String NOT_FOUND_MESSAGE = "Location not found with id: ";
    private final LocationRepository locationRepository;
    private final LocationDetailsRepository locationDetailsRepository;
    private final EventRepository eventRepository;
    private final OfferRepository offerRepository;

    public List<Location> getLocationList(String language) {
        List<Location> locations = locationRepository.findAll();

        locations.forEach(location -> {
            location.setCoordinate(new Coordinate(location.getLongitude(), location.getLatitude()));
            location.setName(language);
        });

        return locations;
    }

    public Location getLocation(long id, String language) {
        Location location = locationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        if (location != null) {
            location.setCoordinate(new Coordinate(location.getLongitude(), location.getLatitude()));
            location.setName(language);
        }

        return location;
    }

    public Location createLocation(LocationRequest locationRequest) {
        Location location = new Location();
        LocationDetails locationDetails = new LocationDetails();

        location.updateFromRequest(locationRequest);
        locationDetails.updateFromRequest(location, locationRequest);

        locationRepository.saveAndFlush(location);
        locationDetailsRepository.saveAndFlush(locationDetails);

        return location;
    }

    public Location updateLocation(long id, LocationRequest locationRequest) {
        Location location = locationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );
        LocationDetails locationDetails = locationDetailsRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        location.updateFromRequest(locationRequest);
        locationDetails.updateFromRequest(location, locationRequest);

        locationDetailsRepository.saveAndFlush(locationDetails);
        locationRepository.saveAndFlush(location);

        return location;
    }

    public Location deleteLocation(long id) {
        Location location = locationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        offerRepository.deleteAllByLocationId(id);
        eventRepository.deleteAllByLocationId(id);
        locationDetailsRepository.deleteById(id);
        locationRepository.deleteById(id);

        return location;
    }
}
