package pl.edu.agh.server.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LocationRequest {
    private String name;
    private String category;
    private String description;
    private String address;
    private String openingHours;
    private String phoneNumber;
    private String websiteUrl;
    private String logoUrl;
    private Coordinate coordinate;
    private List<String> photos;
}
