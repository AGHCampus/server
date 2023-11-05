package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.repostiory.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private static final String NOT_FOUND_MESSAGE = "Event not found with id: ";
    private final EventRepository eventRepository;

    public List<Event> getEventsList() {
        return eventRepository.findAllByOrderByStartDateAsc();
    }
    
    public Event getEvent(long id) {
        return eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );
    }
    
    public Event createEvent(Event event) {
        return eventRepository.saveAndFlush(event);
    }
    
    public Event updateEvent(long id, Event eventDetails) {
        Event event = eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        event.setTitle(eventDetails.getTitle());
        event.setLocationId(eventDetails.getLocationId());
        event.setDescription(eventDetails.getDescription());
        event.setStartDate(eventDetails.getStartDate());
        event.setEndDate(eventDetails.getEndDate());
        event.setWebsiteUrl(eventDetails.getWebsiteUrl());
        event.setImageUrl(eventDetails.getImageUrl());

        return eventRepository.saveAndFlush(event);
    }
    
    public Event deleteEvent(long id) {
        Event event = eventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );

        eventRepository.deleteById(id);

        return event;
    }

    public List<Event> getLocationEvents(long id) {
        return eventRepository.findByLocationIdOrderByStartDateAsc(id);
    }
}
