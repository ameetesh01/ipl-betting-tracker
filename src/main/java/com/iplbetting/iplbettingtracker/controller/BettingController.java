package com.iplbetting.iplbettingtracker.controller;

import com.iplbetting.iplbettingtracker.model.BettingUser;
import com.iplbetting.iplbettingtracker.service.BettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/IplBetting/Users")
public class BettingController {
    private final BettingService bettingService;

    @Autowired
    public BettingController(BettingService bettingService) {
        this.bettingService = bettingService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllBettingUsers() {
        List<String> allBettingUsers = bettingService.getAllBettingUsers();
        return ResponseEntity.ok(allBettingUsers);
    }

    @PostMapping("/CreateUser")
    public ResponseEntity<BettingUser> createBettingUser (@RequestBody BettingUser bettingUser) {
        BettingUser createdUser = bettingService.saveBettingUser(bettingUser);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{name}")
    public ResponseEntity<BettingUser> getBettingUser(@PathVariable String name) {
        BettingUser receivedUser = bettingService.getBettingUserDetails(name);
        if(receivedUser != null){
            return ResponseEntity.ok(receivedUser);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/updateBettingUserDetails")
    public ResponseEntity<BettingUser> updateBettingUser(@RequestBody BettingUser bettingUser) {
        BettingUser updatedUser = bettingService.saveBettingUser(bettingUser);
        if(bettingUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }
}
