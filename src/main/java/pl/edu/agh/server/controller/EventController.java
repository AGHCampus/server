package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.server.common.requests.EventRequest;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.service.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping(value = "", produces = "application/json")
    public List<Event> getEventsList(@RequestParam Optional<Long> locationId, @RequestParam String lang) {
        return eventService.getEventsList(locationId, lang);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Event getEvent(@PathVariable long id, @RequestParam String lang) {
        return eventService.getEvent(id, lang);
    }

    @PostMapping(value = "", produces = "application/json")
    public Event createEvent(@RequestBody EventRequest eventRequest) {
        return eventService.createEvent(eventRequest);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Event updateEvent(@PathVariable long id, @RequestBody EventRequest eventRequest) {
        return eventService.updateEvent(id, eventRequest);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Event deleteEvent(@PathVariable long id) {
        return eventService.deleteEvent(id);
    }
}
