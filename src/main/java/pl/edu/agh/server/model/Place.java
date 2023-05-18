package pl.edu.agh.server.model;

import jakarta.persistence.*;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PlaceDetails placeDetails;

    private String name;
    private String category;
    private double longitude;
    private double latitude;
}
