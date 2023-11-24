package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.common.requests.EventRequest;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.repostiory.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private static final String NOT_FOUND_MESSAGE = "Event not found with id: ";
    private final EventRepository eventRepository;

    public List<Event> getEventsList(Optional<Long> locationId, String language) {
        List<Event> events;
        if (locationId.isPresent()) {
            events = eventRepository.findByLocationIdOrderByStartDateAsc(locationId.get());
        } else {
            events = eventRepository.findAllByOrderByStartDateAsc();
        }
        events.forEach(event -> {
            event.setDescription(language);
            event.setTitle(language);
        });

        return events;
    }

    public Event getEvent(long id, String language) {
        Event event = eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );
        event.setDescription(language);
        event.setTitle(language);

        return event;
    }

    public Event createEvent(EventRequest eventRequest) {
        Event event = new Event();
        event.updateFromRequest(eventRequest);

        return eventRepository.saveAndFlush(event);
    }

    public Event updateEvent(long id, EventRequest eventRequest) {
        Event event = eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        event.updateFromRequest(eventRequest);

        return eventRepository.saveAndFlush(event);
    }

    public Event deleteEvent(long id) {
        Event event = eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        eventRepository.deleteById(id);

        return event;
    }
}
