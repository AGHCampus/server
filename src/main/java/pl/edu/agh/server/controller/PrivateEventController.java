package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.model.PrivateEvent;
import pl.edu.agh.server.service.PrivateEventService;

import java.util.List;

@RestController
@RequestMapping("private-events")
@RequiredArgsConstructor
@CrossOrigin
public class PrivateEventController {
    private final PrivateEventService privateEventService;

    @GetMapping(value = "", produces = "application/json")
    public List<PrivateEvent> getPrivateEventsList() {
        return privateEventService.getPrivateEventsList();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public PrivateEvent getPrivateEvent(@PathVariable long id) {
        return privateEventService.getPrivateEvent(id);
    }

    @PostMapping(value = "", produces = "application/json")
    public PrivateEvent createPrivateEvent(@RequestBody PrivateEvent privateEvent) {
        return privateEventService.createPrivateEvent(privateEvent);
    }
}
