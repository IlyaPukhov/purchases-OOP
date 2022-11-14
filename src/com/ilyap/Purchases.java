package com.ilyap;
//Option #1

public class Purchases {
    public static void main(String[] args) {
        int expensiveProduct = 0;
        int inexpensiveProduct = 0;
        int largestAmount = 0;
        int smallestAmount = 0;
        int expensivePurchase = 0;
        int inexpensivePurchase = 0;
        double sum = 0;
        double sumCount = 0;

        int[] id = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15};
        double[] amounts = new double[]{1.0, 2.3, 4.0, 0.1, 5.5, 10.0, 213.0, 2.0, 3.4, 0.1, 20.5};
        double[] prices = new double[]{15.0, 13.3, 18.1, 11.0, 67.0, 23.0, 11.1, 18.1, 12.1, 23.3, 14};
        int n = id.length;
        double[] sums = new double[n];

        for (int i = 0; i < n; i++) {
            sums[i] = amounts[i] * prices[i];
            System.out.printf("Товар %d: Количество: %.2f, Цена: %.2f, Стоимость: %.2f", id[i], amounts[i], prices[i], sums[i]);
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            if (prices[i] > prices[expensiveProduct]) {
                expensiveProduct = i;
            }
            if (prices[i] < prices[inexpensiveProduct]) {
                inexpensiveProduct = i;
            }
            if (amounts[i] > amounts[largestAmount]) {
                largestAmount = i;
            }
            if (amounts[i] < amounts[smallestAmount]) {
                smallestAmount = i;
            }
            if (sums[i] > sums[expensivePurchase]) {
                expensivePurchase = i;
            }
            if (sums[i] < sums[inexpensiveProduct]) {
                inexpensivePurchase = i;
            }

            sum += sums[i];
            sumCount += amounts[i];
        }

        System.out.println("Самый дорогой товар (ID): " + (expensiveProduct + 1));
        System.out.println("Самый дешевый товар (ID): " + (inexpensiveProduct + 1));
        System.out.println("Наибольшее количество (ID): " + (largestAmount + 1));
        System.out.println("Наименьшее количество (ID): " + (smallestAmount + 1));
        System.out.println("Самая дорогая покупка (ID): " + (expensivePurchase + 1));
        System.out.println("Самая дешевая покупка (ID): " + (inexpensivePurchase + 1));
        System.out.printf("Сумма покупок: %.2f", sum);
        System.out.println();
        System.out.printf("Сумма количества: %.2f", sumCount);
    }
}
