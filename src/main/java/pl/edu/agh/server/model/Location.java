package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.edu.agh.server.service.common.Coordinate;

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
    @JsonIgnore
    private double longitude;

    @Getter
    @Setter
    @JsonIgnore
    private double latitude;

    @Getter
    @Setter
    private String logoUrl;

    @Transient
    @Getter
    @Setter
    private Coordinate coordinate;
}
