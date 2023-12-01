package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import pl.edu.agh.server.common.requests.EventRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Table(name = "events")
@Log4j2
public class Event {
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

    @ElementCollection
    @JsonIgnore
    @Column(length = 2048)
    private Map<String, String> descriptionTranslations = new HashMap<>();

    @Column(length = 2048)
    @Transient
    private String description;

    @ElementCollection
    @JsonIgnore
    private Map<String, String> titleTranslations = new HashMap<>();

    @Transient
    private String title;

    private String imageUrl;
    private String websiteUrl;

    public void updateFromRequest(EventRequest event) {
        this.locationId = event.getLocationId();
        this.descriptionTranslations.putAll(event.getDescriptionTranslations());
        this.titleTranslations.putAll(event.getTitleTranslations());
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.websiteUrl = event.getWebsiteUrl();
        this.imageUrl = event.getImageUrl();
    }

    public void setDescription(String language) {
        String description = descriptionTranslations.get(language);

        if (description == null) {
            log.error("Language {} not found for description with event id {}.", language.toUpperCase(), id);
        }

        this.description = description;
    }

    public void setTitle(String language) {
        String title = titleTranslations.get(language);

        if (title == null) {
            log.error("Language {} not found for title with event id {}.", language.toUpperCase(), id);
        }

        this.title = title;
    }
}
