package com.bridgelabz.cabinvoicegenerator;

public class CabInvoiceGenerator {

    private static final double COST_PER_KM = 10.0;
    private static final int COST_PER_MINUTE = 1;
    private static final double MIN_FARE = 5.0;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        return Math.max(totalFare, MIN_FARE);
    }
}
