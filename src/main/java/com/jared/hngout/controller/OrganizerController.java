package com.jared.hngout.controller;


import com.jared.hngout.dto.OrganizerDto;
import com.jared.hngout.model.Organizer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jared.hngout.service.OrganizerService;

import java.util.List;

@RestController
@RequestMapping("/organizers")
public class OrganizerController{
private final OrganizerService organizerService;          // field, ends with ;

public OrganizerController(OrganizerService organizerService){   // constructor, has ()
    this.organizerService = organizerService;
}
    @PostMapping
    public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer){
        Organizer created= organizerService.createOrganizer(organizer);
        if(created==null){
            return ResponseEntity.notFound().build();
        }
         return ResponseEntity.status(201).body(created);
    }
    @GetMapping
    public ResponseEntity <List<Organizer>> getAllOrganizer(){
        return ResponseEntity.ok(organizerService.getAllOrganizer());

    }
    @GetMapping("/{organizerId}")
    public ResponseEntity<OrganizerDto> getOne(@PathVariable Long organizerId){
        OrganizerDto organizer=organizerService.getOrganizerById(organizerId);
        if (organizer==null){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(organizer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer data){
        Organizer updated= organizerService.updateOrganizer(id,data);
        if (updated==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        boolean deleted = organizerService.deleteOrganizer(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}




