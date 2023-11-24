package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.common.requests.OfferRequest;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.service.OfferService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("offers")
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;

    @GetMapping(value = "", produces = "application/json")
    public List<Offer> getOffersList(@RequestParam Optional<Long> locationId, @RequestParam String lang) {
        return offerService.getOffersList(locationId, lang);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Offer getOffer(@PathVariable long id, @RequestParam String lang) {
        return offerService.getOffer(id, lang);
    }

    @PostMapping(value = "", produces = "application/json")
    public Offer createOffer(@RequestBody OfferRequest offer) {
        return offerService.createOffer(offer);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Offer updateOffer(@PathVariable long id, @RequestBody OfferRequest offerDetails) {
        return offerService.updateOffer(id, offerDetails);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Offer deleteOffer(@PathVariable long id) {
        return offerService.deleteOffer(id);
    }
}
