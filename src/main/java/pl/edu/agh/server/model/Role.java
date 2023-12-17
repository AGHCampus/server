package pl.edu.agh.server.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "roles")
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(unique = true)
    private String authority;

    @ManyToMany
    @JoinTable(
            name = "roles_locations",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "location_id")}
    )
    private Set<Location> locations;

    public Set<Long> getAssociatedLocationIds() {
        return locations.stream().map(Location::getId).collect(Collectors.toSet());
    }

    public void addLocation(Location location) {
        this.locations.add(location);
    }
}
