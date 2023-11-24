package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.common.requests.InformationRequest;
import pl.edu.agh.server.model.Information;
import pl.edu.agh.server.service.InformationService;

import java.util.List;

@RestController
@RequestMapping("information")
@RequiredArgsConstructor
public class InformationController {
    private final InformationService informationService;

    @GetMapping(value = "", produces = "application/json")
    public List<Information> getInformationList(@RequestParam String lang) {
        return informationService.getInformationList(lang);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Information getInformation(@PathVariable long id, @RequestParam String lang) {
        return informationService.getInformation(id, lang);
    }

    @PostMapping(value = "", produces = "application/json")
    public Information createInformation(@RequestBody InformationRequest informationRequest) {
        return informationService.createInformation(informationRequest);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Information updateInformation(@PathVariable long id, @RequestBody InformationRequest informationRequest) {
        return informationService.updateInformation(id, informationRequest);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Information deleteInformation(@PathVariable long id) {
        return informationService.deleteInformation(id);
    }
}
