package com.semantic.example.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.semantic.example.service.RevenueCalculator;

public class RevenueCalculatorImpl implements RevenueCalculator {

    public BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods) {
        return costOfGoods.divide(BigDecimal.ONE.subtract(marginPercentage).setScale(2, RoundingMode.CEILING), 2,
                RoundingMode.CEILING);
    }

}
