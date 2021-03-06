package com.company;

/**
 * Created by Martha on 18.03.15.
 */
public class Dish {
    private int quantity;
    private Recipe recipe;

    public Dish(Recipe recipe, int quantity) {
        this.quantity = quantity;
        this.recipe = recipe.cloneForDish();
    }

    public void incrementQuantity(){
        ++this.quantity;
    }

    @Override
    public String toString(){
        String description = "com.company.Dish name " + this.recipe.getNameOfRecipe() + "\t quantity " + this.quantity + "\n";
        description = String.join("", description, recipe.toString());
        return description;
    }

    // region Setters and Getters

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    // endregion
}
