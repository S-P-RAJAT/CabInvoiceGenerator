package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

public class CabInvoiceGenerator {

    RideRepository rideRepository;

    public CabInvoiceGenerator() {
        rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time, RideType rideType) {
        double totalFare = distance * rideType.getCostPerKm() + time * rideType.getCostPerMinute();
        return Math.max(totalFare, rideType.getMinimumFare());
    }

    public double calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time, ride.rideType);
        }
        System.out.println(totalFare);
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

    public void addRideToRepository(String[] userIdList, Ride[][] rides) {
        for (int i = 0; i < userIdList.length; i++) {
            for (int j = 0; j < rides[i].length; j++) {
                rideRepository.addRideForUser(userIdList[i], rides[i][j]);
            }
        }
    }
}
