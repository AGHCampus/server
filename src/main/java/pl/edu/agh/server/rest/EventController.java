package pl.edu.agh.server.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.repostiory.EventRepository;

import java.util.List;

@RestController
@RequestMapping("event")
@RequiredArgsConstructor
public class EventController {
    private final EventRepository eventRepository;

    @GetMapping(value = "/all", produces = "application/json")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<Event> getPlaceEvents(@PathVariable long id) {
        return eventRepository.findByPlaceId(id);
    }
}
