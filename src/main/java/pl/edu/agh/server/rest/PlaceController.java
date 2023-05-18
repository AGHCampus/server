package pl.edu.agh.server.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.model.Place;
import pl.edu.agh.server.model.PlaceDetails;
import pl.edu.agh.server.repostiory.PlaceDetailsRepository;
import pl.edu.agh.server.repostiory.PlaceRepository;

import java.util.List;

@RestController
@RequestMapping("place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceRepository placeRepository;
    private final PlaceDetailsRepository placeDetailsRepository;

    @GetMapping(value = "/", produces = "application/json")
    public List<Place> getPlaceList() {
        return placeRepository.findAll();
    }

    @GetMapping(value = "/{id}/details", produces = "application/json")
    public PlaceDetails getPlaceDetails(@PathVariable long id) {
        return placeDetailsRepository.getReferenceById(id);
    }
}
