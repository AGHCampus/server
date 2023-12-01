package pl.edu.agh.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public List<Event> getEventsList(@RequestParam Optional<Long> locationId) {
        return eventService.getEventsList(locationId);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Event getEvent(@PathVariable long id) {
        return eventService.getEvent(id);
    }

    @PostMapping(value = "", produces = "application/json")
    public Event createEvent(@RequestBody Event eventDetails) {
        return eventService.createEvent(eventDetails);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public Event updateEvent(@PathVariable long id, @RequestBody Event eventDetails) {
        return eventService.updateEvent(id, eventDetails);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public Event deleteEvent(@PathVariable long id) {
        return eventService.deleteEvent(id);
    }
}
