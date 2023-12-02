package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import pl.edu.agh.server.common.requests.InformationRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Entity
@Data
@Table(name = "information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @CreationTimestamp
    private Date timestamp;

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(length = 2048)
    private Map<String, String> contentTranslations = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> titleTranslations = new HashMap<>();

    @Column(length = 2048)
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String content;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    public void updateFromRequest(InformationRequest informationRequest) {
        this.contentTranslations.putAll(informationRequest.getContentTranslations());
        this.titleTranslations.putAll(informationRequest.getTitleTranslations());
    }

    public void setContent(String language) {
        String translatedContent = contentTranslations.get(language.toLowerCase());

        if (translatedContent == null) {
            log.error("Language {} not found for content with information id {}.", language.toUpperCase(), id);
        }

        this.content = translatedContent;
    }

    public void setTitle(String language) {
        String translatedTitle = titleTranslations.get(language.toLowerCase());

        if (translatedTitle == null) {
            log.error("Language {} not found for title with information id {}.", language.toUpperCase(), id);
        }

        this.title = translatedTitle;
    }
}
