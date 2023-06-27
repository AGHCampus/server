package pl.edu.agh.server.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PlaceDetails placeDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<PlaceOffer> placeOffers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<PlaceEvent> placeEvents;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String category;

    @Getter
    @Setter
    private double longitude;

    @Getter
    @Setter
    private double latitude;
}
