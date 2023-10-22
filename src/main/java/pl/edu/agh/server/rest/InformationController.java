package pl.edu.agh.server.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.model.Information;
import pl.edu.agh.server.repostiory.InformationRepository;

import java.util.List;

@RestController
@RequestMapping("information")
@RequiredArgsConstructor
public class InformationController {
    private final InformationRepository informationRepository;

    @GetMapping(value = "/all", produces = "application/json")
    public List<Information> getInformationList() {
        return informationRepository.findAll();
    }
}
