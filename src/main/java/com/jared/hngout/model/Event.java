
package com.jared.hngout.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;
    private String category;
    private String dateTime;
    private String location;
    private int maxMembers;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToMany(mappedBy = "events")
    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public Event(Organizer organizer, String eventName, String category,
                 String dateTime, String location, int maxMembers) {
        this.organizer = organizer;
        this.eventName = eventName;
        this.category = category;
        this.dateTime = dateTime;
        this.location = location;
        this.maxMembers = maxMembers;
    }
}