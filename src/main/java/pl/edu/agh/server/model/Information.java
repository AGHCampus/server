package pl.edu.agh.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;
import pl.edu.agh.server.common.InformationRequest;

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

    @ElementCollection
    @JsonIgnore
    private Map<String, String> contentTranslations = new HashMap<>();

    @ElementCollection
    @JsonIgnore
    private Map<String, String> titleTranslations = new HashMap<>();

    @Column(length = 2048)
    @Transient
    private String content;

    @Transient
    private String title;

    public void updateFromRequest(InformationRequest informationRequest) {
        this.contentTranslations.putAll(informationRequest.getContentTranslations());
        this.titleTranslations.putAll(informationRequest.getTitleTranslations());
    }

    public void setContent(String language) {
        String content = contentTranslations.get(language);

        if (content == null) {
            log.error("Language {} not found for content with information id {}.", language.toUpperCase(), id);
        }

        this.content = content;
    }

    public void setTitle(String language) {
        String title = titleTranslations.get(language);

        if (title == null) {
            log.error("Language {} not found for title with information id {}.", language.toUpperCase(), id);
        }

        this.title = title;
    }
}
