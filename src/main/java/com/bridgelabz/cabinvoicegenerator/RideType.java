package com.bridgelabz.cabinvoicegenerator;

public enum RideType {
    NORMAL(10.0,1,5.0), PREMIUM(15.0,2,20.0);

    private final double costPerKm;
    private final int costPerMinute;
    private final double minimumFare;

    RideType(double costPerKm, int costPerMinute, double minimumFare) {
        this.costPerKm = costPerKm;
        this.costPerMinute = costPerMinute;
        this.minimumFare = minimumFare;
    }

    public double getCostPerKm() {
        return costPerKm;
    }

    public int getCostPerMinute() {
        return costPerMinute;
    }

    public double getMinimumFare() {
        return minimumFare;
    }
}
