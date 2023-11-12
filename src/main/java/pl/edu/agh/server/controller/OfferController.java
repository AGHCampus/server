package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.service.OfferService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("offers")
@RequiredArgsConstructor
@CrossOrigin
public class OfferController {
    private final OfferService offerService;

    @GetMapping(value = "", produces = "application/json")
    public List<Offer> getOffersList(@RequestParam Optional<Long> locationId) {
        return offerService.getOffersList(locationId);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Offer getOffer(@PathVariable long id) {
        return offerService.getOffer(id);
    }

    @PostMapping(value = "", produces = "application/json")
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.createOffer(offer);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Offer updateOffer(@PathVariable long id, @RequestBody Offer offerDetails) {
        return offerService.updateOffer(id, offerDetails);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Offer deleteOffer(@PathVariable long id) {
        return offerService.deleteOffer(id);
    }
}
