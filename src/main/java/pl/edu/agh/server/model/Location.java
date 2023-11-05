package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.edu.agh.server.common.Coordinate;
import pl.edu.agh.server.common.LocationRequest;

import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private LocationDetails locationDetails;

    @OneToMany(mappedBy = "location")
    private List<Offer> offers;

    @OneToMany(mappedBy = "location")
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

    public void updateFromRequest(LocationRequest locationRequest) {
        this.name = locationRequest.getName();
        this.category = locationRequest.getCategory();
        this.longitude = locationRequest.getCoordinate().getLongitude();
        this.latitude = locationRequest.getCoordinate().getLatitude();
    }
}
