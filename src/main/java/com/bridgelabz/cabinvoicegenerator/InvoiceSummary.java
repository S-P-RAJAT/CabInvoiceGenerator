package com.bridgelabz.cabinvoicegenerator;

public class InvoiceSummary {

    private final int numberOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.numberOfRides;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        InvoiceSummary that = (InvoiceSummary) object;
        if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(that.averageFare))
            return false;
        if (numberOfRides != that.numberOfRides)
            return false;
        return Double.doubleToLongBits(totalFare) == Double.doubleToLongBits(that.totalFare);
    }
}