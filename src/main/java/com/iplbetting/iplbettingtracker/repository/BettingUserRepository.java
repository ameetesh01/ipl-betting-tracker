package com.iplbetting.iplbettingtracker.repository;

import com.iplbetting.iplbettingtracker.model.BettingUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BettingUserRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public BettingUserRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public BettingUser save(BettingUser bettingUser) {
        redisTemplate.opsForHash().put("BettingUser", bettingUser.getName(), bettingUser);
        return bettingUser;
    }

    public List<BettingUser> findAll() {
        List<Object> users = redisTemplate.opsForHash().values("BettingUser");
        return users.stream()
                .map(user -> (BettingUser) user)
                .collect(Collectors.toList());
    }

    public BettingUser findByName(String name) {
        return (BettingUser) redisTemplate.opsForHash().get("BettingUser",name);
    }

}
