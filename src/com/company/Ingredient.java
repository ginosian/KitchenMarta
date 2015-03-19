package com.company;

/**
 * Created by Martha on 18.03.15.
 */
public class Ingredient {
    private String name;
    private double quantity;
    private double unitPrice;

    public Ingredient(String name, double quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\tQuantity: " + quantity + "\tUnit Price:" + unitPrice;
    }

    public Ingredient cloneForRecipe(double quantity){
        return new Ingredient(this.name, quantity, this.unitPrice*quantity);
    }

    // region Setterd and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    // endregion

}
