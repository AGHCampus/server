package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.service.OfferService;

import java.util.List;

@RestController
@RequestMapping("offer")
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;

    @GetMapping(value = "/all", produces = "application/json")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<Offer> getLocationOffers(@PathVariable long id) {
        return offerService.getLocationOffers(id);
    }
}
