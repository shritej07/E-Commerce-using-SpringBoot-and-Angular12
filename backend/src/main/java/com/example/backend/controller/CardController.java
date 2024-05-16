package com.example.backend.controller;

import com.example.backend.model.CardDetails;
import com.example.backend.model.User;
import com.example.backend.service.CardService;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class CardController {

    @Autowired
    CardService cardService;

    @Autowired
    UserService userService;

    //Login
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return userService.loginUser(user);
    }

    @GetMapping("/details")
    public List<CardDetails> findAll(){
        return cardService.findCardDetails();
    }

    @PostMapping("/details")
    public CardDetails addAll(@RequestBody CardDetails obj){
        return cardService.addCardDetails(obj);
    }

    @GetMapping("/details/{id}")
    public Optional<CardDetails> findById(@PathVariable int id){
        return cardService.findById(id);
    }

    @PutMapping("/details/{id}")
    public CardDetails updateHolder(@PathVariable int id, @RequestBody CardDetails cardDetails){
        return cardService.updateDetails(id, cardDetails);
    }

    @DeleteMapping("/details/{id}")
    public void delete(@PathVariable int id){
        cardService.deleteById(id);
    }


}
