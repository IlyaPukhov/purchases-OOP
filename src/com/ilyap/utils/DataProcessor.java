package com.ilyap.utils;

import com.ilyap.exception.InputDataException;
import com.ilyap.purchases.AnotherPurchase;
import com.ilyap.purchases.Purchase;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DataProcessor<T extends Purchase> {
    private final List<T> purchases;

    public DataProcessor(List<T> purchases) {
        this.purchases = purchases;
    }

    public void printPurchasesInPriceRange(double from, double to, int limit) {
        if (from > to || limit < 0) {
            throw new InputDataException("Incorrect input data!");
        }

        List<AnotherPurchase> anotherPurchases = purchases.stream()
                .filter(purchase -> purchase.getPrice() > from && purchase.getPrice() < to)
                .sorted(Comparator.comparing(T::getPrice))
                .limit(limit)
                .map(purchase -> new AnotherPurchase(purchase.getId(), purchase.getPrice()))
                .toList();
        anotherPurchases.forEach(AnotherPurchase::printInfo);
    }

    public void printPurchaseByPrice(double price) {
        if (price < 0) {
            throw new InputDataException("Incorrect price!");
        }

        Optional<AnotherPurchase> purchaseOptional = purchases.stream()
                .filter(purchase -> purchase.getPrice() == price)
                .map(purchase -> new AnotherPurchase(purchase.getId(), purchase.getPrice()))
                .findFirst();

        purchaseOptional.ifPresent(AnotherPurchase::printInfo);
    }
}

