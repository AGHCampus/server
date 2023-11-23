package pl.edu.agh.server.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class EventRequest {
    private Date startDate;
    private Date endDate;
    private Long locationId;
    private Map<String, String> descriptionTranslations;
    private Map<String, String> titleTranslations;
    private String imageUrl;
    private String websiteUrl;
}
