package com.ilyap.purchases;

import com.ilyap.Printer;

public class AnotherPurchase implements Printer {
    private final int id;
    private double price;


    public AnotherPurchase(int id, double price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public void printInfo() {
        System.out.printf("Товар %d: Цена: %.2f\n",
                this.getId() + 1, this.getPrice());
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
