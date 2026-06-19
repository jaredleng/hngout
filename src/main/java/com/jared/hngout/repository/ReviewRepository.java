package com.jared.hngout.repository;

import com.jared.hngout.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReviewRepository extends JpaRepository<Review, Long> {}