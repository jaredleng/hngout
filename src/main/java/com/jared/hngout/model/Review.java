
package com.jared.hngout.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double rating;
    private String text;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member author;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Review(double rating, String text, Member author, Event event) {
        this.rating = rating;
        this.text = text;
        this.author = author;
        this.event = event;
    }
}