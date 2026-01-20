package com.jmartin.support.service;

import com.jmartin.support.model.RoundRobinStatus;
import com.jmartin.support.model.User;
public class RoundRobinResult {
    private final RoundRobinStatus status;
    private final User agentAssigned;

    public RoundRobinResult(RoundRobinStatus status, User agentAssigned) {
        this.status = status;
        this.agentAssigned = agentAssigned;
    }

    public RoundRobinStatus getStatus() {return status;}
    public User getAgentAssigned() {return agentAssigned;}
}
