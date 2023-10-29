package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.model.Information;
import pl.edu.agh.server.service.InformationService;

import java.util.List;

@RestController
@RequestMapping("information")
@RequiredArgsConstructor
public class InformationController {
    private final InformationService informationService;

    @GetMapping(value = "/all", produces = "application/json")
    public List<Information> getInformationList() {
        return informationService.getInformationList();
    }
}
