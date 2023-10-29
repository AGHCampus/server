package pl.edu.agh.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.server.model.Event;
import pl.edu.agh.server.repostiory.EventRepository;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAllByOrderByStartDateAsc();

    }

    public List<Event> getLocationEvents(long id) {
        return eventRepository.findByLocationIdOrderByStartDateAsc(id);
    }
}
