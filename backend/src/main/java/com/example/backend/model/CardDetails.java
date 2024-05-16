package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "card_details")
public class CardDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "card_number")
    private long cardNumber;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "pin")
    private int pin;

    @ManyToOne
    @JoinColumn(name = "card_holder_id")
    private CardHolder cardHolder;

    public CardDetails() {}

    public CardDetails(int id, long cardNumber, int cvv, int pin, CardHolder cardHolder) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.pin = pin;
        this.cardHolder = cardHolder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }
}


