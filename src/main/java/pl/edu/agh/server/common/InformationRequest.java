package pl.edu.agh.server.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class InformationRequest {
    private Map<String, String> contentTranslations;
    private Map<String, String> titleTranslations;
}
