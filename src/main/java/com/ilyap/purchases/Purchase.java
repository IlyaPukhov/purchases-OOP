package com.ilyap.purchases;

import com.ilyap.Printer;

import java.util.Objects;

public class Purchase implements Printer {
    private final int id;
    private static int nextId;
    private double amount;
    private double price;

    public Purchase() {
        this.id = getNextId();
    }

    public Purchase(double amount, double price) {
        this.id = getNextId();
        this.amount = amount;
        this.price = price;
    }

    public double getSum() {
        return amount * price;
    }

    @Override
    public String getInfo() {
        return String.format("Товар %d: Количество: %.2f, Цена: %.2f, Стоимость: %.2f",
                this.getId() + 1, this.getAmount(), this.getPrice(), this.getSum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return id == purchase.id && Double.compare(purchase.amount, amount) == 0 && Double.compare(purchase.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, price);
    }

    public int getId() {
        return id;
    }

    protected static int getNextId() {
        return nextId++;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

