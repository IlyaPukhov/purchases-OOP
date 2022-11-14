package com.ilyap.utils;

import com.ilyap.purchases.Purchase;

import java.util.List;

public final class PurchasesStatistics {

    private PurchasesStatistics() {
    }

    public static void printStatistics(List<Purchase> purchases) {
        int expensiveProductId = 0;
        int inexpensiveProductId = 0;
        int largestAmountId = 0;
        int smallestAmountId = 0;
        int expensivePurchaseId = 0;
        int inexpensivePurchaseId = 0;
        double sum = 0;
        double sumCount = 0;

        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).getPrice() > purchases.get(expensiveProductId).getPrice()) {
                expensiveProductId = i;
            }
            if (purchases.get(i).getPrice() < purchases.get(inexpensiveProductId).getPrice()) {
                inexpensiveProductId = i;
            }
            if (purchases.get(i).getAmount() > purchases.get(largestAmountId).getAmount()) {
                largestAmountId = i;
            }
            if (purchases.get(i).getAmount() < purchases.get(smallestAmountId).getAmount()) {
                smallestAmountId = i;
            }
            if (purchases.get(i).getSum() > purchases.get(expensivePurchaseId).getSum()) {
                expensivePurchaseId = i;
            }
            if (purchases.get(i).getSum() < purchases.get(inexpensivePurchaseId).getSum()) {
                inexpensivePurchaseId = i;
            }

            sum += purchases.get(i).getSum();
            sumCount += purchases.get(i).getAmount();
        }

        System.out.println("Самый дорогой товар (ID): " + (expensiveProductId + 1));
        System.out.println("Самый дешевый товар (ID): " + (inexpensiveProductId + 1));
        System.out.println("Наибольшее количество (ID): " + (largestAmountId + 1));
        System.out.println("Наименьшее количество (ID): " + (smallestAmountId + 1));
        System.out.println("Самая дорогая покупка (ID): " + (expensivePurchaseId + 1));
        System.out.println("Самая дешевая покупка (ID): " + (inexpensivePurchaseId + 1));
        System.out.printf("Сумма покупок: %.2f\n", sum);
        System.out.printf("Сумма количества: %.2f\n", sumCount);
    }
}

