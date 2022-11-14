package com.ilyap.utils;

import com.ilyap.purchases.Purchase;

import java.util.Comparator;
import java.util.List;

public class PurchasesStatistics {
    List<Purchase> list;

    public PurchasesStatistics(List<Purchase> purchases) {
        this.list = purchases;
    }

    public int getExpensiveProduct() {
        return list.stream()
                .max(Comparator.comparing(Purchase::getPrice))
                .map(Purchase::getId)
                .orElse(-1);
    }

    public int getInexpensiveProduct() {
        return list.stream()
                .min(Comparator.comparing(Purchase::getPrice))
                .map(Purchase::getId)
                .orElse(-1);
    }

    public int getLargestAmountPurchase() {
        return list.stream()
                .max(Comparator.comparing(Purchase::getAmount))
                .map(Purchase::getId)
                .orElse(-1);
    }

    public int getSmallestAmountPurchase() {
        return list.stream()
                .min(Comparator.comparing(Purchase::getAmount))
                .map(Purchase::getId)
                .orElse(-1);
    }

    public int getExpensivePurchase() {
        return list.stream()
                .max(Comparator.comparing(Purchase::getSum))
                .map(Purchase::getId)
                .orElse(-1);
    }

    public int getInexpensivePurchase() {
        return list.stream()
                .min(Comparator.comparing(Purchase::getSum))
                .map(Purchase::getId)
                .orElse(-1);
    }

    public double getSum() {
        return list.stream()
                .mapToDouble(Purchase::getSum)
                .sum();
    }

    public double getSumAmount() {
        return list.stream()
                .mapToDouble(Purchase::getAmount)
                .sum();
    }

    public void printStatistics() {
        System.out.println("Самый дорогой товар (ID): " + getExpensiveProduct());
        System.out.println("Самый дешевый товар (ID): " + getInexpensiveProduct());
        System.out.println("Наибольшее количество (ID): " + getLargestAmountPurchase());
        System.out.println("Наименьшее количество (ID): " + getSmallestAmountPurchase());
        System.out.println("Самая дорогая покупка (ID): " + getExpensivePurchase());
        System.out.println("Самая дешевая покупка (ID): " + getInexpensivePurchase());
        System.out.printf("Сумма покупок: %.2f\n", getSum());
        System.out.printf("Сумма количества: %.2f\n", getSumAmount());
    }
}

