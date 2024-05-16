package com.example.backend.repository;

import com.example.backend.model.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardHolderRepo extends JpaRepository<CardHolder, Integer> {
}
