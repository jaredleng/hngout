package com.jared.hngout.service;

import com.jared.hngout.dto.OrganizerDto;
import com.jared.hngout.model.Organizer;
import com.jared.hngout.repository.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository){
        this.organizerRepository = organizerRepository;
    }
    private OrganizerDto toDto(Organizer organizer){
        return new OrganizerDto(
                organizer.getId(),
                organizer.getName(),
                organizer.getEmail(),
                organizer.getContactNumber(),
                organizer.getCompanyRegNumber()


        );
    }

    public OrganizerDto getOrganizerById(Long id){
        Organizer organizer=organizerRepository.findById(id).orElse(null);
        if (organizer==null){
            return null;
        }
        return toDto(organizer);

    }

    public Organizer createOrganizer(Organizer organizer){
        return organizerRepository.save(organizer);
    }

    public List<Organizer> getAllOrganizer(){
        return organizerRepository.findAll();
    }



    public Organizer updateOrganizer(Long id, Organizer newData){
        Organizer organizer = organizerRepository.findById(id).orElse(null);
        if (organizer == null) {
            return null;
        }
        organizer.setName(newData.getName());
        organizer.setEmail(newData.getEmail());
        organizer.setPassword(newData.getPassword());
        organizer.setContactNumber(newData.getContactNumber());
        organizer.setCompanyRegNumber(newData.getCompanyRegNumber());
        return organizerRepository.save(organizer);
    }

    public boolean deleteOrganizer(Long id){
        boolean exist = organizerRepository.existsById(id);
        if (!exist) {
            return false;
        }
        organizerRepository.deleteById(id);
        return true;
    }
}