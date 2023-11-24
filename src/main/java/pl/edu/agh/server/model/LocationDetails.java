package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import pl.edu.agh.server.common.LocationRequest;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "locationsDetails")
public class LocationDetails {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @JsonIgnore
    private Location location;

    private String phoneNumber;
    private String websiteUrl;
    private String description;
    private String openingHours;

    @CreationTimestamp
    @JsonIgnore
    private Date timestamp;

    @LastModifiedDate
    @JsonIgnore
    protected Date lastModifiedDate;

    @ElementCollection
    private List<String> photos;

    public void updateFromRequest(Location location, LocationRequest locationRequest) {
        this.location = location;
        this.description = locationRequest.getDescription();
        this.openingHours = locationRequest.getOpeningHours();
        this.phoneNumber = locationRequest.getPhoneNumber();
        this.websiteUrl = locationRequest.getWebsiteUrl();
        this.photos = locationRequest.getPhotos();
    }
}
