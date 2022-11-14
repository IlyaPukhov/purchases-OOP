package com.ilyap;
//Option #1

import com.ilyap.exception.InputDataException;
import com.ilyap.purchases.AnotherPurchase;
import com.ilyap.purchases.PromotionalPurchase;
import com.ilyap.purchases.Purchase;
import com.ilyap.utils.DataProcessor;
import com.ilyap.utils.PurchasesStatistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PurchasesRunner {
    public static void main(String[] args) {

        List<Purchase> purchases = new ArrayList<>(Arrays.asList(
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
        ));

        purchases.forEach(Purchase::printInfo);

        PurchasesStatistics purchasesStatistics = new PurchasesStatistics(purchases);
        purchasesStatistics.printStatistics();

        DataProcessor<Purchase> dataProcessor = new DataProcessor<>(purchases);

        double priceFrom = 15;
        double priceTo = 25;
        int limit = 5;
        System.out.println("\nПоиск покупок (до " + limit + ") с ценой в промежутке [" + priceFrom + ", " + priceTo + "] ...");
        try {
            dataProcessor.getPurchasesInPriceRange(priceFrom, priceTo, limit).forEach(AnotherPurchase::printInfo);
        } catch (InputDataException e) {
            System.out.println(e.getMessage());
        }

        double price = 18.1;
        System.out.println("\nПоиск покупки с ценой = " + price + " ...");
        try {
            Optional<AnotherPurchase> optionalAnotherPurchase = dataProcessor.getPurchaseByPrice(price);

            optionalAnotherPurchase.ifPresentOrElse(AnotherPurchase::printInfo,
                    () -> System.out.println("Упс, ничего не нашлось :)")
            );
        } catch (InputDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
