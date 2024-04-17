package com.iplbetting.iplbettingtracker.service;

import com.iplbetting.iplbettingtracker.model.BettingUser;
import com.iplbetting.iplbettingtracker.repository.BettingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BettingService {
    @Autowired
    private BettingUserRepository bettingUserRepository;

    public BettingUser saveBettingUser(BettingUser bettingUser) {
        return bettingUserRepository.save(bettingUser);
    }

    public List<String> getAllBettingUsers() {
        List<BettingUser> bettingUserList = bettingUserRepository.findAll();
        if(bettingUserList == null || bettingUserList.size() == 0){
            return Collections.emptyList();
        }
        List<String> listOfBettingUsers = new ArrayList<>();
        bettingUserList.forEach(
                (user) -> {
                    listOfBettingUsers.add(user.getName());
                }
        );
        return listOfBettingUsers;
    }

//    public BettingUser updateBettingUser(BettingUser bettingUser) {
//        return bettingUserRepository.save(bettingUser);
//    }

    public BettingUser getBettingUserDetails(String name) {
        return bettingUserRepository.findByName(name);
    }
}
