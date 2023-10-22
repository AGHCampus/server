package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Place place;

    @CreationTimestamp
    private Date timestamp;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;

    @Column(insertable = false, updatable = false)
    private Long place_id;

    @Column(length = 2048)
    private String description;
    private String title;
    private String place_name;
    private String image_url;
    private String website_url;
}
