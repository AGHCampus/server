package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import pl.edu.agh.server.common.Coordinate;

import java.util.Date;

@Entity
@Data
@Table(name = "privateEvents")
public class PrivateEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


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

    @Column(length = 2048)
    private String description;

    private String title;
    private String imageUrl;

    @JsonIgnore
    private double latitude;
    @JsonIgnore
    private double longitude;

    @Transient
    private Coordinate coordinate;

    public void updateFromRequest(PrivateEvent privateEvent) {
        if (privateEvent.getCoordinate() != null) {
            this.longitude = privateEvent.getCoordinate().getLongitude();
            this.latitude = privateEvent.getCoordinate().getLatitude();
        }
        this.imageUrl = privateEvent.getImageUrl();
        this.title = privateEvent.getTitle();
        this.startDate = privateEvent.getStartDate();
        this.endDate = privateEvent.getEndDate();
        this.description = privateEvent.getDescription();
    }
}
