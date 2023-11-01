package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.Location;
import pl.edu.agh.server.repostiory.LocationRepository;
import pl.edu.agh.server.service.common.Coordinate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<Location> getLocationList() {
        List<Location> locations = locationRepository.findAll();

        locations.forEach(location -> location.setCoordinate(new Coordinate(location.getLongitude(), location.getLatitude())));

        return locations;
    }
}
