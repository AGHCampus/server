package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

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

    private String phone_number;
    private String websiteUrl;
    private String address;
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
}
