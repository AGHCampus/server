package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.common.requests.EventRequest;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.repostiory.EventRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EventService {
    private static final String NOT_FOUND_MESSAGE = "Event not found with id: ";
    private final EventRepository eventRepository;
    private final CurrentUserService currentUserService;

    public List<Event> getTranslatedEventsList(Optional<Long> locationId, String language) {
        List<Event> events;
        Date date = new Date();
        if (locationId.isPresent()) {
            events = eventRepository.findByLocationIdOrderByStartDateAsc(locationId.get(), date);
        } else {
            events = eventRepository.findAllByOrderByStartDateAsc(date);
        }
        events.forEach(event -> {
            event.setDescription(language);
            event.setTitle(language);
            event.setDescriptionTranslations(null);
            event.setTitleTranslations(null);
        });

        return events;
    }

    public List<Event> getEventsList() {
        if (currentUserService.hasAdminPermissions()) {
            return eventRepository.findAllByOrderByStartDateDesc() ;
        }

        Set<Long> locationIds = currentUserService.getLocationIds();
        return eventRepository.findAllByLocationIdInOrderByStartDateDesc(locationIds);
    }

    public Event getTanslatedEvent(long id, String language) {
        Event event = eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );
        event.setDescription(language);
        event.setTitle(language);
        event.setDescriptionTranslations(null);
        event.setTitleTranslations(null);

        return event;
    }

    public Event getEvent(long id) {
        Event event =  eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        if (currentUserService.isUnauthorizedForLocation(event.getLocationId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

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

        if (currentUserService.isUnauthorizedForLocation(event.getLocationId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        event.updateFromRequest(eventRequest);

        return eventRepository.saveAndFlush(event);
    }

    public Event deleteEvent(long id) {
        Event event = eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        if (currentUserService.isUnauthorizedForLocation(event.getLocationId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        eventRepository.deleteById(id);

        return event;
    }
}
