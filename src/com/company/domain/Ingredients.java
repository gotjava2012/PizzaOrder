package com.company.domain;

public class Ingredients {
   private String ingredient;
   private int quantity;

    public Ingredients(String ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredients() {

    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredient='" + ingredient + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
