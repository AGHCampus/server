package pl.edu.agh.server.common;

import lombok.Getter;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.model.LocationDetails;
import pl.edu.agh.server.model.Offer;

import java.util.List;

public class LocationContent {
    @Getter
    List<Offer> offers;

    @Getter
    List<Event> events;

    @Getter
    LocationDetails locationDetails;

    public LocationContent(List<Offer> offers, List<Event> events, LocationDetails locationDetails) {
        this.offers = offers;
        this.events = events;
        this.locationDetails = locationDetails;
    }
}
