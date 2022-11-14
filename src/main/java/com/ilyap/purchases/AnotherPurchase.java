package com.ilyap.purchases;

import com.ilyap.Printer;

import java.util.Objects;

public class AnotherPurchase implements Printer {
    private final int id;
    private double price;

    public AnotherPurchase() {
        this.id = Purchase.getNextId();
    }

    public AnotherPurchase(int id, double price) {
        this.id = id;
        this.price = price;
    }


    @Override
    public void printInfo() {
        System.out.printf("Товар %d: Цена: %.2f\n",
                this.getId() + 1, this.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnotherPurchase that = (AnotherPurchase) o;
        return id == that.id && Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
