package com.ilyap;

public class Purchase implements Printer {
    private int id;
    private static int nextId;
    private double amount;
    private double price;

    public Purchase() {
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
    public void printInfo() {
        System.out.printf("Товар %d: Количество: %.2f, Цена: %.2f, Стоимость: %.2f\n",
                this.getId() + 1, this.getAmount(), this.getPrice(), this.getSum());
    }

    protected static int getNextId() {
        return nextId++;
    }

    public int getId() {
        return id;
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

