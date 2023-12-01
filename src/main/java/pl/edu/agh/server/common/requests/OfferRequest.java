package pl.edu.agh.server.common.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class OfferRequest {
    private Long locationId;
    private Date startDate;
    private Date endDate;
    private Map<String, String> descriptionTranslations;
    private String imageUrl;
    private String websiteUrl;
}
