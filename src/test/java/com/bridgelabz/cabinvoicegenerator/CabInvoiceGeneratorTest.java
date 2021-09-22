package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator cabInvoiceGenerator;

    @Before
    public void setUp() {
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ReturnTotalFare() {
        double distance = 5.0;
        int time = 9;
        double fare = cabInvoiceGenerator.calculateFare(distance, time, RideType.NORMAL);
        Assert.assertEquals(59, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time, RideType.NORMAL);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ReturnInvoiceSummary() {
        ArrayList<Ride> rides = new ArrayList<>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.01, 1));
        InvoiceSummary summary = cabInvoiceGenerator.returnRideSummary(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserId_ReturnInvoiceSummary() {
        String[] userIdList = {"Ram", "Rahul", "Raghav"};
        Ride[][] rides = {{new Ride(5.0, 12), new Ride(2.5, 6)}, {new Ride(3.0, 5), new Ride(0.01, 1)},
                {new Ride(10.0, 15), new Ride(2, 30)}};

        cabInvoiceGenerator.addRideToRepository(userIdList, rides);
        InvoiceSummary summary = cabInvoiceGenerator.invoiceForUser(userIdList[2]);
        InvoiceSummary expectedSummary = new InvoiceSummary(rides[2].length, 165.0);
        Assert.assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenPremiumTypeAndUserId_ReturnInvoiceSummary() {
        String[] userIdList = {"Ram", "Rahul", "Raghav"};
        Ride[][] rides = {{new Ride(5.0, 12, RideType.PREMIUM), new Ride(2.5, 6)}, {new Ride(3.0, 5), new Ride(0.01, 1)},
                {new Ride(10.0, 15, RideType.PREMIUM), new Ride(2, 30, RideType.PREMIUM)}};

        cabInvoiceGenerator.addRideToRepository(userIdList, rides);
        InvoiceSummary summary = cabInvoiceGenerator.invoiceForUser(userIdList[2]);
        InvoiceSummary expectedSummary = new InvoiceSummary(rides[2].length, 270.0);
        Assert.assertEquals(expectedSummary, summary);
    }

}