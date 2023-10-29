package pl.edu.agh.server.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "locations_details")
public class LocationDetails {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Location location;

    private String phone_number;
    private String website_url;
    private String address;
    private String description;
    private String opening_hours;

    @CreationTimestamp
    private Date timestamp;

    @LastModifiedDate
    protected Date last_modified_date;

    @ElementCollection
    private List<String> photos;
}
