package pl.edu.agh.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.Information;
import pl.edu.agh.server.repostiory.InformationRepository;

import java.util.List;

@Service
public class InformationService {
    @Autowired
    InformationRepository informationRepository;

    public List<Information> getInformationList() {
        return informationRepository.findAll();
    }
}
