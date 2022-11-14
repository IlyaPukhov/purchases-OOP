package com.ilyap.utils;

import com.ilyap.purchases.Purchase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchasesStatisticsTest {

    @Mock
    private static List<Purchase> emptyList = new ArrayList<>();

    private static final List<Purchase> list = new ArrayList<>();
    private final PurchasesStatistics purchasesStatistics = new PurchasesStatistics(list);
    private final PurchasesStatistics purchasesStatisticsEmpty = new PurchasesStatistics(emptyList);

    @BeforeAll
    static void setUp() {
        for (int i = 0; i < 5; i++) {
            list.add(new Purchase(3.0 * (i + 1), 5.0 * (i + 1)));
        }
    }

    @DisplayName("Get expensive product id")
    @Test
    void getExpensiveProduct() {
        assertEquals(4, purchasesStatistics.getExpensiveProduct());
        assertEquals(-1, purchasesStatisticsEmpty.getExpensiveProduct());
    }

    @DisplayName("Get inexpensive product id")
    @Test
    void getInexpensiveProduct() {
        assertEquals(0, purchasesStatistics.getInexpensiveProduct());
        assertEquals(-1, purchasesStatisticsEmpty.getInexpensiveProduct());
    }

    @DisplayName("Get largest purchase id")
    @Test
    void getLargestAmountPurchase() {
        assertEquals(4, purchasesStatistics.getLargestAmountPurchase());
        assertEquals(-1, purchasesStatisticsEmpty.getLargestAmountPurchase());
    }

    @DisplayName("Get smallest purchase id")
    @Test
    void getSmallestAmountPurchase() {
        assertEquals(0, purchasesStatistics.getSmallestAmountPurchase());
        assertEquals(-1, purchasesStatisticsEmpty.getSmallestAmountPurchase());
    }

    @DisplayName("Get expensive purchase id")
    @Test
    void getExpensivePurchase() {
        assertEquals(4, purchasesStatistics.getExpensivePurchase());
        assertEquals(-1, purchasesStatisticsEmpty.getExpensivePurchase());
    }

    @DisplayName("Get inexpensive purchase id")
    @Test
    void getInexpensivePurchase() {
        assertEquals(0, purchasesStatistics.getInexpensivePurchase());
        assertEquals(-1, purchasesStatisticsEmpty.getInexpensivePurchase());
    }

    @DisplayName("Get sum of purchases")
    @Test
    void getSum() {
        assertEquals(825, purchasesStatistics.getSum());
        assertEquals(0, purchasesStatisticsEmpty.getSum());
    }

    @DisplayName("Get sum of purchases amounts")
    @Test
    void getSumAmount() {
        assertEquals(45, purchasesStatistics.getSumAmount());
        assertEquals(0, purchasesStatisticsEmpty.getSumAmount());
    }
}