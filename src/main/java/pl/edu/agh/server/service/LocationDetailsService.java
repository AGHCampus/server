package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.repostiory.LocationDetailsRepository;

@Service
@RequiredArgsConstructor
public class LocationDetailsService {
    private final LocationDetailsRepository locationDetailsRepository;

    public LocationDetails getLocationDetails(long id, String language) {
        LocationDetails locationDetails = locationDetailsRepository.findById(id).orElse(null);

        if (locationDetails != null) {
            locationDetails.setDescription(language);
        }

        return locationDetails;
    }
}
