package pl.edu.agh.server.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class LocationRequest {
    private Map<String, String> nameTranslations;
    private String category;
    private Map<String, String> descriptionTranslations;
    private String address;
    private String openingHours;
    private String phoneNumber;
    private String websiteUrl;
    private String logoUrl;
    private Coordinate coordinate;
    private List<String> photos;
}
