package com.ilyap.purchases;

import com.ilyap.Printer;

public class PromotionalPurchase extends Purchase implements Printer {
    private final int id;
    private double amount;

    public PromotionalPurchase(double amount) {
        this.id = getNextId();
        this.amount = amount;
    }

    @Override
    public String getInfo() {
        return String.format("Товар %d: Количество: %.2f — акционный товар",
                this.getId() + 1, this.getAmount());
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

}
