package com.semantic.example.service;

import java.math.BigDecimal;
public interface RevenueCalculator {
    BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods);
}
