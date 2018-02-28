package com.semantic.example.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class RevenueCalculatorImplTest {

    private RevenueCalculatorImpl revenueCalculatorImpl = new RevenueCalculatorImpl();

    @Test
    public void testCalculateRevenue() {
        Assert.assertEquals(new BigDecimal(500.00).setScale(2, RoundingMode.CEILING),
                revenueCalculatorImpl.calculateRevenue(new BigDecimal(.2), new BigDecimal(400)));
    }

    @Test
    public void testCalculateRevenueForReturnValueOfTwoDecimalValues() {
        Assert.assertEquals(new BigDecimal(125.07).setScale(2, RoundingMode.CEILING),
                revenueCalculatorImpl.calculateRevenue(new BigDecimal(.2), new BigDecimal(100.05)));
    }

    @Ignore
    public void testCalculateRevenueWhenMarginIsNull() {
        revenueCalculatorImpl.calculateRevenue(null, new BigDecimal(100.05));
    }

    @Ignore
    public void testCalculateRevenueWhenCostOfGoodsIsNull() {
        revenueCalculatorImpl.calculateRevenue(new BigDecimal(100.05), null);
    }

}
