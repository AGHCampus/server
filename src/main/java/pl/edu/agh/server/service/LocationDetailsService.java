package pl.edu.agh.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.repostiory.LocationDetailsRepository;

@Service
public class LocationDetailsService {
    @Autowired
    private LocationDetailsRepository locationDetailsRepository;

    public LocationDetails getLocationDetails(long id) {
        return locationDetailsRepository.findById(id).orElse(null);
    }
}
