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
@Table(name = "events")
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

    @Column(length = 2048)
    private String description;
    private String title;
    private String imageUrl;
    private String websiteUrl;
}
