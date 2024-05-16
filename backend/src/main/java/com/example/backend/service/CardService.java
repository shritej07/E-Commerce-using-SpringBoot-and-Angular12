package com.example.backend.service;

import com.example.backend.model.CardDetails;
import com.example.backend.model.CardHolder;
import com.example.backend.repository.CardDetailsRepo;
import com.example.backend.repository.CardHolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardDetailsRepo cardDetailsRepo;

    @Autowired
    CardHolderRepo cardHolderRepo;

    //getAll
    public List<CardDetails> findCardDetails(){
        return cardDetailsRepo.findAll();
    }

    //addAll
    public CardDetails addCardDetails(CardDetails obj) {
        CardHolder cardHolder = obj.getCardHolder();
        if (cardHolder != null && cardHolder.getId() == 0) {
            cardHolder = cardHolderRepo.save(cardHolder);
            obj.setCardHolder(cardHolder);
        }
        return cardDetailsRepo.save(obj);
    }

    //findById
    public Optional<CardDetails> findById(int id) {
        return cardDetailsRepo.findById(id);
    }

    //updateHolder
    public CardDetails updateDetails(int id, CardDetails cardDetails){

        Optional<CardDetails> cardDetails1 = cardDetailsRepo.findById(id);
            CardDetails cdDetail = cardDetails1.get();

            cdDetail.setCardHolder(cardDetails.getCardHolder());
            cdDetail.setCardNumber(cardDetails.getCardNumber());
            cdDetail.setPin(cardDetails.getPin());
            cdDetail.setCvv(cardDetails.getCvv());
            return cardDetailsRepo.save(cdDetail);
    }

    //deleteHolder
    public void deleteById(int id){
        cardDetailsRepo.deleteById(id);
    }
}
