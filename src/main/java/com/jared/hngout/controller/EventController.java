package com.jared.hngout.controller;
import com.jared.hngout.service.EventService;
import com.jared.hngout.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService){
        this.eventService=eventService;
    }
    @PostMapping("/{organizerId}")
    public ResponseEntity<Event> create(@PathVariable Long organizerId,
                                        @RequestBody Event event){
        Event created= eventService.createEvent(organizerId,event);
        if(created==null){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.status(201).body(created);

    }

    // constructor injection

    // POST  /events        -> create        (@PostMapping, @RequestBody Event)
    @GetMapping
    public ResponseEntity <List<Event>>getAll(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }


    // GET   /events        -> list all      (@GetMapping)
    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getOne(
            @PathVariable Long eventId) {
        Event event= eventService.getEventById(eventId);
        if (event == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(event);
    }
    // GET   /events/{id}   -> get one       (@GetMapping("/{id}"), @PathVariable)
    // PUT   /events/{id}   -> update        (@PutMapping)
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id ,@RequestBody Event event){
        Event updated= eventService.updateEvent(id,event);
        if (updated==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        boolean deleted = eventService.deleteEvent(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    // DELETE /events/{id}  -> delete        (@DeleteMapping)
}