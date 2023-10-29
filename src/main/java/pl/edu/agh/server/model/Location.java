package pl.edu.agh.server.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private LocationDetails locationDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<Offer> offers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<Event> events;

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

    @Getter
    @Setter
    private String logo_url;
}
