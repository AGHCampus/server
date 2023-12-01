package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import pl.edu.agh.server.common.requests.LocationRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
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

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(length = 2048)
    private Map<String, String> descriptionTranslations = new HashMap<>();

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
        this.descriptionTranslations.putAll(locationRequest.getDescriptionTranslations());
        this.openingHours = locationRequest.getOpeningHours();
        this.phoneNumber = locationRequest.getPhoneNumber();
        this.websiteUrl = locationRequest.getWebsiteUrl();
        this.photos = locationRequest.getPhotos();
    }

    public void setDescription(String language) {
        String localizedDescription = descriptionTranslations.get(language.toLowerCase());

        if (localizedDescription == null) {
            log.error("Language {} not found for description with locationDetails id {}.", language.toUpperCase(), id);
        }

        this.description = localizedDescription;
    }
}
