package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.model.Information;
import pl.edu.agh.server.service.InformationService;

import java.util.List;

@RestController
@RequestMapping("information")
@RequiredArgsConstructor
public class InformationController {
    private final InformationService informationService;

    @GetMapping(value = "", produces = "application/json")
    public List<Information> getInformationList() {
        return informationService.getInformationList();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Information getInformation(@PathVariable long id) {
        return informationService.getInformation(id);
    }

    @PostMapping(value = "", produces = "application/json")
    public Information createInformation(@RequestBody Information information) {
        return informationService.createInformation(information);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Information updateInformation(@PathVariable long id, @RequestBody Information informationDetails) {
        return informationService.updateInformation(id, informationDetails);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Information deleteInformation(@PathVariable long id) {
        return informationService.deleteInformation(id);
    }
}
