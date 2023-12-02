package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.common.requests.InformationRequest;
import pl.edu.agh.server.model.Information;
import pl.edu.agh.server.repostiory.InformationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationService {
    private static final String NOT_FOUND_MESSAGE = "Information not found with id: ";
    private final InformationRepository informationRepository;

    public List<Information> getTranslatedInformationList(String language) {
        List<Information> information = informationRepository.findAll();

        information.forEach(event -> {
            event.setContent(language);
            event.setTitle(language);
            event.setContentTranslations(null);
            event.setTitleTranslations(null);
        });

        return information;
    }

    public List<Information> getInformationList() {
        return informationRepository.findAll();
    }

    public Information getTranslatedInformation(long id, String language) {
        Information information = informationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );
        information.setContent(language);
        information.setTitle(language);
        information.setTitleTranslations(null);
        information.setContentTranslations(null);

        return information;
    }

    public Information getInformation(long id) {
        return informationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );
    }

    public Information createInformation(InformationRequest informationRequest) {
        Information information = new Information();
        information.updateFromRequest(informationRequest);

        return informationRepository.saveAndFlush(information);
    }

    public Information updateInformation(long id, InformationRequest informationRequest) {
        Information information = informationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        information.updateFromRequest(informationRequest);

        return informationRepository.saveAndFlush(information);
    }

    public Information deleteInformation(long id) {
        Information information = informationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        informationRepository.deleteById(id);

        return information;
    }
}
