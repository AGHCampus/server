package pl.edu.agh.server.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "places_details")
public class PlaceDetails {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Place place;

    private String phone_number;
    private String url;
    private String address;
    private String description;

    @ElementCollection
    private List<String> photos;
}
