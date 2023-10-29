package pl.edu.agh.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.Location;
import pl.edu.agh.server.repostiory.LocationRepository;
import pl.edu.agh.server.service.common.Coordinate;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocationList() {
        List<Location> locations = locationRepository.findAll();

        locations.forEach(location -> location.setCoordinate(new Coordinate(location.getLongitude(), location.getLatitude())));

        return locations;
    }
}
