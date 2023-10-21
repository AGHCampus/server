package pl.edu.agh.server.common;

import lombok.Getter;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.model.Offer;
import pl.edu.agh.server.model.PlaceDetails;

import java.util.List;

public class LocationContent {
    @Getter
    List<Offer> offers;

    @Getter
    List<Event> events;

    @Getter
    PlaceDetails placeDetails;

    public LocationContent(List<Offer> offers, List<Event> events, PlaceDetails placeDetails) {
        this.offers = offers;
        this.events = events;
        this.placeDetails = placeDetails;
    }
}
