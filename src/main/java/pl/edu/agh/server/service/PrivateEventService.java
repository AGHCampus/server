package pl.edu.agh.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.agh.server.common.Coordinate;
import pl.edu.agh.server.model.PrivateEvent;
import pl.edu.agh.server.repostiory.PrivateEventRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PrivateEventService {
    private static final String NOT_FOUND_MESSAGE = "Event not found with id: ";

    private final PrivateEventRepository privateEventRepository;

    public List<PrivateEvent> getPrivateEventsList() {
        List<PrivateEvent> privateEvents = privateEventRepository.findAllByOrderByStartDateAsc();
        privateEvents.forEach(privateEvent -> privateEvent.setCoordinate(new Coordinate(privateEvent.getLongitude(), privateEvent.getLatitude())));

        return privateEvents;
    }

    public PrivateEvent getPrivateEvent(long id) {
        PrivateEvent privateEvent = privateEventRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE + id)
        );
        if (privateEvent != null) {
            privateEvent.setCoordinate(new Coordinate(privateEvent.getLongitude(), privateEvent.getLatitude()));
        }

        return privateEvent;
    }

    public PrivateEvent createPrivateEvent(PrivateEvent privateEventRequest) {
        PrivateEvent privateEvent = new PrivateEvent();
        privateEvent.updateFromRequest(privateEventRequest);

        return privateEventRepository.saveAndFlush(privateEvent);
    }
}
