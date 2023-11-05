package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.model.Information;
import pl.edu.agh.server.repostiory.InformationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationService {
    private final InformationRepository informationRepository;

    public List<Information> getInformationList() {
        return informationRepository.findAll();
    }

    public Information getInformation(long id) {
        return informationRepository.findById(id).orElse(null);
    }

    public Information createInformation(Information information) {
        return informationRepository.saveAndFlush(information);
    }

    public Information updateInformation(long id, Information informationDetails) {
        Information information = informationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Information not found with id: " + id)
        );

        information.setTitle(informationDetails.getTitle());
        information.setContent(informationDetails.getContent());

        return informationRepository.saveAndFlush(information);
    }

    public Information deleteInformation(long id) {
        Information information = informationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Information not found with id: " + id)
        );

        informationRepository.deleteById(id);

        return information;
    }
}
