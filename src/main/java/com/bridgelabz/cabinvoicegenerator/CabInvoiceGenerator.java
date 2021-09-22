package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public class CabInvoiceGenerator {

    private static final double COST_PER_KM = 10.0;
    private static final int COST_PER_MINUTE = 1;
    private static final double MIN_FARE = 5.0;
    RideRepository rideRepository;

    public CabInvoiceGenerator() {
        rideRepository = new RideRepository();
    }
    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        return Math.max(totalFare, MIN_FARE);
    }
    public double calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance,ride.time);
        }
        return totalFare;
    }
    public InvoiceSummary returnRideSummary(List<Ride> rides) {
        double totalFare = calculateFare(rides);
        int numberOfRides = rides.size();
        return new InvoiceSummary(numberOfRides, totalFare);
    }
    public InvoiceSummary invoiceForUser(String userId) {
        return returnRideSummary(rideRepository.getRidesForUser(userId));
    }

    public void addRideToRepository(String[] userIdList, Ride[][] rides){
        for(int i = 0; i < userIdList.length; i++) {
            for (int j = 0; j < rides[i].length; j++) {
                rideRepository.addRideForUser(userIdList[i], rides[i][j]);
            }
        }
    }
}
