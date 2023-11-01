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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id")
    @JsonIgnore
    private Location location;

    @CreationTimestamp
    @JsonIgnore
    private Date timestamp;

    @LastModifiedDate
    @JsonIgnore
    protected Date lastModifiedDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;

    @Column(insertable = false, updatable = false)
    private Long locationId;

    @Column(length = 2048)
    private String description;
    private String title;
    private String imageUrl;
    private String websiteUrl;
}
