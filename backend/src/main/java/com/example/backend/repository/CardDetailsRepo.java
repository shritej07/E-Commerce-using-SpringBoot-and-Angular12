package com.example.backend.repository;

import com.example.backend.model.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDetailsRepo extends JpaRepository<CardDetails, Integer> {
}
