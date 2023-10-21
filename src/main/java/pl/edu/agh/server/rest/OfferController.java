package pl.edu.agh.server.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.repostiory.OfferRepository;

import java.util.List;

@RestController
@RequestMapping("offer")
@RequiredArgsConstructor
public class OfferController {
    private final OfferRepository offerRepository;

    @GetMapping(value = "/", produces = "application/json")
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<Offer> getPlaceOffers(@PathVariable long id) {
        return offerRepository.findByPlaceId(id);
    }
}
