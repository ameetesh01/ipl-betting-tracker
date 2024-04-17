package com.iplbetting.iplbettingtracker.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("BettingUser")
public class BettingUser implements Serializable {
    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalInvested() {
        return totalInvested;
    }

    public void setTotalInvested(Integer totalInvested) {
        this.totalInvested = totalInvested;
    }

    public Integer getTotalReturn() {
        return totalReturn;
    }

    public void setTotalReturn(Integer totalReturn) {
        this.totalReturn = totalReturn;
    }

    private Integer totalInvested;
    private Integer totalReturn;
}
