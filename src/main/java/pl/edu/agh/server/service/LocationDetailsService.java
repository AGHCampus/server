package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.repostiory.LocationDetailsRepository;

@Service
@RequiredArgsConstructor
public class LocationDetailsService {
    private static final String NOT_FOUND_MESSAGE = "Location details not found with id: ";
    private final LocationDetailsRepository locationDetailsRepository;

    public LocationDetails getLocalizedLocationDetails(long id, String language) {
        LocationDetails locationDetails = locationDetailsRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        locationDetails.setDescription(language);
        locationDetails.setDescriptionTranslations(null);

        return locationDetails;
    }

    public LocationDetails getLocationDetails(long id) {
        return locationDetailsRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );
    }
}
