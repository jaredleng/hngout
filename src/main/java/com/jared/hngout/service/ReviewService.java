package com.jared.hngout.service;
import com.jared.hngout.model.Event;
import com.jared.hngout.model.Member;
import com.jared.hngout.model.Review;
import com.jared.hngout.repository.EventRepository;
import com.jared.hngout.repository.MemberRepository;
import com.jared.hngout.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;
    // constructor injecting all THREE (review needs author + event lookups)
    public ReviewService(ReviewRepository reviewRepository,MemberRepository memberRepository
            ,EventRepository eventRepository){
        this.reviewRepository=reviewRepository;
        this.memberRepository=memberRepository;
        this.eventRepository=eventRepository;
    }
    @Transactional

    public Review addReview(Long memberId, Long eventId, Review review) {
        Member member=memberRepository.findById(memberId).orElse(null);
        Event event=eventRepository.findById(eventId).orElse(null);
        if(member==null||event==null){
            return null;
        }
        if(!event.getMembers().contains(member)){
            return null;
        }
        review.setAuthor(member);
        review.setEvent(event);
        return reviewRepository.save(review);

        // 1. find the member (the author)
        // 2. find the event
        // 3. if either is null -> return null
        // 4. GATEKEEPER: check the member actually joined the event
        //    -> if (!event.getMembers().contains(member)) return null;  (or some signal)
        // 5. attach author + event to the review
        // 6. save and return
    }
    // getReviewsForEvent(Long eventId) -> for Figure 10 (reviews by event)
    public List<Review> getReviewsForEvent(Long eventId){
        Event event=eventRepository.findById(eventId).orElse(null);
        if(event==null){
            return null;
        }
        return event.getReviews();
    }



}