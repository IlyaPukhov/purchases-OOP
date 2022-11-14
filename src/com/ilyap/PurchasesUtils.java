package com.ilyap;

public final class PurchasesUtils {

    private PurchasesUtils() {
    }

    public static void printStatistics(Purchase[] purchases) {
        int expensiveProductId = 0;
        int inexpensiveProductId = 0;
        int largestAmountId = 0;
        int smallestAmountId = 0;
        int expensivePurchaseId = 0;
        int inexpensivePurchaseId = 0;
        double sum = 0;
        double sumCount = 0;

        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i].getPrice() > purchases[expensiveProductId].getPrice()) {
                expensiveProductId = i;
            }
            if (purchases[i].getPrice() < purchases[inexpensiveProductId].getPrice()) {
                inexpensiveProductId = i;
            }
            if (purchases[i].getAmount() > purchases[largestAmountId].getAmount()) {
                largestAmountId = i;
            }
            if (purchases[i].getAmount() < purchases[smallestAmountId].getAmount()) {
                smallestAmountId = i;
            }
            if (purchases[i].getSum() > purchases[expensivePurchaseId].getSum()) {
                expensivePurchaseId = i;
            }
            if (purchases[i].getSum() < purchases[inexpensivePurchaseId].getSum()) {
                inexpensivePurchaseId = i;
            }

            sum += purchases[i].getSum();
            sumCount += purchases[i].getAmount();
        }

        System.out.println("Самый дорогой товар (ID): " + (expensiveProductId + 1));
        System.out.println("Самый дешевый товар (ID): " + (inexpensiveProductId + 1));
        System.out.println("Наибольшее количество (ID): " + (largestAmountId + 1));
        System.out.println("Наименьшее количество (ID): " + (smallestAmountId + 1));
        System.out.println("Самая дорогая покупка (ID): " + (expensivePurchaseId + 1));
        System.out.println("Самая дешевая покупка (ID): " + (inexpensivePurchaseId + 1));
        System.out.printf("Сумма покупок: %.2f\n", sum);
        System.out.printf("Сумма количества: %.2f", sumCount);
    }
}

