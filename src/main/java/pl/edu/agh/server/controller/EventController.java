package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.service.EventService;

import java.util.List;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<Event> getLocationEvents(@PathVariable long id) {
        return eventService.getLocationEvents(id);
    }
}
