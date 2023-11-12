package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Location location;

    @CreationTimestamp
    @JsonIgnore
    private Date timestamp;

    @LastModifiedDate
    @JsonIgnore
    protected Date lastModifiedDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date endDate;

    private Long locationId;

    private String description;
    private String imageUrl;
    private String websiteUrl;

    public void updateFromRequest(Offer offer) {
        this.locationId = offer.getLocationId();
        this.description = offer.getDescription();
        this.startDate = offer.getStartDate();
        this.endDate = offer.getEndDate();
        this.websiteUrl = offer.getWebsiteUrl();
        this.imageUrl = offer.getImageUrl();
    }
}
