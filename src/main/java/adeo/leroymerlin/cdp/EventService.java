package adeo.leroymerlin.cdp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAllBy();
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    /**
     *
     * @param query
     * @return new List of events filtered by their title event
     */
    public List<Event> getFilteredEvents(String query) {
        List<Event> events = eventRepository.findAllBy();
        // Filter the events list in pure JAVA here
        List<Event> filteredEvent = new ArrayList<>();
        for (Event event :
                events) {
            if(query.equals(event.getTitle())) {
                filteredEvent.add(event);
            }
        }

        return filteredEvent;
    }
}
