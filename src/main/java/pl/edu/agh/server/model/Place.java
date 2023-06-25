package pl.edu.agh.server.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public  Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PlaceDetails placeDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private List<PlaceOffer> placeOffers;

    private String name;
    private String category;
    private double longitude;
    private double latitude;
}
