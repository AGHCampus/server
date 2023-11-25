package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import pl.edu.agh.server.common.Coordinate;
import pl.edu.agh.server.common.requests.LocationRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
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
    @Transient
    private String name;

    @ElementCollection
    @JsonIgnore
    private Map<String, String> nameTranslations = new HashMap<>();

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

    @Getter
    @Setter
    private String address;

    @Transient
    @Getter
    @Setter
    private Coordinate coordinate;

    public void updateFromRequest(LocationRequest locationRequest) {
        this.nameTranslations.putAll(locationRequest.getNameTranslations());
        this.category = locationRequest.getCategory();
        if (locationRequest.getCoordinate() != null) {
            this.longitude = locationRequest.getCoordinate().getLongitude();
            this.latitude = locationRequest.getCoordinate().getLatitude();
        }
        this.logoUrl = locationRequest.getLogoUrl();
        this.address = locationRequest.getAddress();
    }

    public void setName(String language) {
        String name = nameTranslations.get(language);

        if (name == null) {
            log.error("Language {} not found for location name with location id {}.", language.toUpperCase(), id);
        }

        this.name = name;
    }
}
