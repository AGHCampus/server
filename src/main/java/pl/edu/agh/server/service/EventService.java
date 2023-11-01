package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.repostiory.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAllByOrderByStartDateAsc();

    }

    public List<Event> getLocationEvents(long id) {
        return eventRepository.findByLocationIdOrderByStartDateAsc(id);
    }
}
