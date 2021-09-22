package com.bridgelabz.cabinvoicegenerator;

import java.util.*;

public class RideRepository {

    Map<String, List<Ride>> userRides = new HashMap<>();

    public void addRideForUser(String userID, Ride ride) {
        this.userRides.computeIfAbsent(userID, k -> new LinkedList<>());
        this.userRides.get(userID).add(ride);
    }

    public List<Ride> getRidesForUser(String userId) {
        return userRides.get(userId);
    }

}