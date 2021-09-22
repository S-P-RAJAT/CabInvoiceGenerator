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
    public void givenMultipleRides_ReturnInvoiceSummary(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.01, 1) };
        InvoiceSummary summary = cabInvoiceGenerator.returnRideSummary(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
}