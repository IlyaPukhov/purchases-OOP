package com.ilyap;
//Option #1

public class PurchasesRunner {
    public static void main(String[] args) {

        Purchase[] purchases = new Purchase[]{
                new Purchase(1.0, 15.0),
                new Purchase(2.3, 13.3),
                new Purchase(4.0, 18.1),
                new Purchase(0.1, 11.0),
                new Purchase(5.5, 67.0),
                new Purchase(10.0, 23.0),
                new Purchase(213.0, 11.1),
                new Purchase(2.0, 18.1),
                new Purchase(3.4, 12.1),
                new Purchase(0.1, 23.3),
                new Purchase(20.5, 14),
                new PromotionalPurchase(12.7)
        };

        for (Purchase purchase : purchases) {
            purchase.printInfo();
        }

        PurchasesUtils.printStatistics(purchases);
    }
}
