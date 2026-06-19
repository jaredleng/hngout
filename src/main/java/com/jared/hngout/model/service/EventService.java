package com.jared.hngout.service;

import com.jared.hngout.model.Event;
import com.jared.hngout.model.Organizer;
import com.jared.hngout.repository.EventRepository;
import com.jared.hngout.repository.OrganizerRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final OrganizerRepository organizerRepository;
    public EventService(EventRepository eventRepository,OrganizerRepository organizerRepository){
        this.eventRepository=eventRepository;
        this.organizerRepository=organizerRepository;
    }
    public Event createEvent(Long organizerId, Event event) {
        Organizer organizer= organizerRepository.findById(organizerId).orElse(null);
        if (organizer==null){
            return null;
        }
        event.setOrganizer(organizer);
        return eventRepository.save(event);// one line: call the repository's save method
    }
    public List <Event>getAllEvents() {

        return eventRepository.findAll();  // one line: call the repository's findAll method

    }
    public Event getEventById(Long id) {
        // findById returns an Optional<User>, not a User directly.
        // For now, use .orElse(null) to unwrap it.
        return eventRepository.findById(id).orElse(null);  // i.e. userRepository.findById(id).orElse(null)
    }
    public Event updateEvent(Long id, Event newData) {
        Event existing = eventRepository.findById(id).orElse(null);// 1. Try to find existing user by id (use repository.findById(id).orElse(null))
        if (existing == null) {
            return null; // 2. If null, return null (controller will return 404)
        }
        existing.setEventName(newData.getEventName());
        existing.setCategory(newData.getCategory());
        existing.setDateTime(newData.getDateTime());
        existing.setLocation(newData.getLocation());
        existing.setMaxMembers(newData.getMaxMembers());

        return eventRepository.save(existing);

    }
    public boolean deleteEvent(Long id) {
        boolean exists = eventRepository.existsById(id);
        if (!exists) {
            return false;
        } else {
            eventRepository.deleteById(id);

        }
        return true;
    }


    // constructor injection (the @Autowired-by-constructor pattern you used in FitTrack)

    // createEvent(Event event) -> save and return
    // getAllEvents() -> return all
    // getEventById(Long id) -> return one (think about what to do if not found)
}