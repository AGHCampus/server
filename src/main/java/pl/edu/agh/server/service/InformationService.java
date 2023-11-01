package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
}
