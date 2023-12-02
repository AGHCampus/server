package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import pl.edu.agh.server.common.requests.OfferRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Table(name = "offers")
@Log4j2
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
    private Date lastModifiedDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date endDate;

    private Long locationId;

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> descriptionTranslations = new HashMap<>();

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    private String imageUrl;
    private String websiteUrl;

    public void updateFromRequest(OfferRequest offerRequest) {
        this.locationId = offerRequest.getLocationId();
        this.descriptionTranslations.putAll(offerRequest.getDescriptionTranslations());
        this.startDate = offerRequest.getStartDate();
        this.endDate = offerRequest.getEndDate();
        this.websiteUrl = offerRequest.getWebsiteUrl();
        this.imageUrl = offerRequest.getImageUrl();
    }

    public void setDescription(String language) {
        String translatedDescription = descriptionTranslations.get(language.toLowerCase());

        if (translatedDescription == null) {
            log.error("Language {} not found for description with offer id {}.", language.toUpperCase(), id);
        }

        this.description = translatedDescription;
    }
}
