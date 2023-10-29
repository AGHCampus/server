package pl.edu.agh.server.controller;

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

    @GetMapping(value = "/all", produces = "application/json")
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<Offer> getLocationOffers(@PathVariable long id) {
        return offerRepository.findByLocationId(id);
    }
}
