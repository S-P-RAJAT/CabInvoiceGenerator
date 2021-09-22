package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 5.0;
        int time = 9;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(59, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ReturnMinimumFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5, fare, 0.0);
    }
    @Test
    public void givenMultipleRides_ReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
        double fare = cabInvoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30, fare, 0.0);
    }
}