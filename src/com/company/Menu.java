package com.company;

import java.util.Scanner;

/**
 * Created by Marta on 3/19/2015.
 */
public class Menu {
    private Kitchen kitchen;
    Scanner scanner = new Scanner(System.in);

    public Menu() {
        this.kitchen = new Kitchen();
    }

    public void mainMenu(){
        System.out.println("Choose what to do");
        System.out.println("1. Add ingredient");
        System.out.println("2. Remove ingredient");
        System.out.println("3. Add recipe");
        System.out.println("4. Remove recipe");
        System.out.println("5. Show ingredients list");
        System.out.println("6. Show recipes list");
        System.out.println("7. Cook a dish");
        System.out.println("8. Show ready dishes list");
        System.out.println("9. Modify ingredient quantity in kitchen");
    }

    public boolean addIngrdientMenu1(){
        System.out.println("Enter ingredient name, quantity and unit price");
       if(kitchen.addIngredientInKitchen(new Ingredient(scanner.next(), scanner.nextDouble(), scanner.nextDouble()))){
           System.out.println("Ingredient is successfully added");
           return true;
       }
        System.out.println("Ingredient was not added");
        return false;
    }

    public boolean removeIngredientMenu2(){
        if(kitchen.getIngredients().size() == 0){
            System.out.println("Add ingredients first");
            return false;
        }
        System.out.println("Choose which ingredient to remove");
        System.out.println(kitchen.printInfoIngredients());
        int input = scanner.nextInt();
            if(inputLimitsCheck(0, kitchen.getIngredients().size(), input - 1)){
                if(kitchen.removeIngredientFromKitchen(kitchen.getIngredients().get(input-1))){
                System.out.println("Ingredient is successfully removed");
                return true;
                }
            }
        System.out.println("Invalid input, ingredient was not removed");
        return false;
    }

    public void addRecipeMenu3(){
        if(kitchen.getIngredients().size() == 0){
            System.out.println("Add ingredients first");
            return;
        }
        System.out.println("Enter recipe name");
        String recipeName = scanner.next();
        int indexOfRecipe = this.kitchen.returnTheIndexOfRecipeFromKitchen(this.kitchen.addRecipeToKitchen(recipeName));
        int ingredientIndex;
        System.out.println("Choose ingredient for recipe or press 0 to exit");
        System.out.println(kitchen.printInfoIngredients());
        ingredientIndex = scanner.nextInt();
            do {
                if (inputLimitsCheck(1,kitchen.getIngredients().size(), ingredientIndex) && kitchen.containsIngredientInKitchen(kitchen.getIngredients().get(ingredientIndex-1))) {
                    System.out.println("Enter ingredient quantity in recipe");
                    kitchen.getRecipes().get(indexOfRecipe).addIngredient(kitchen.getIngredients().get(ingredientIndex-1), scanner.nextDouble());
                    System.out.println("Ingredient is successfully added");
                }
                else {
                    System.out.println("Invalid input, try again");
                }
                System.out.println("Choose ingredient for recipe or press 0 to exit");
                System.out.println(kitchen.printInfoIngredients());
                ingredientIndex = scanner.nextInt();
            }
            while (ingredientIndex != 0);
    }

    public boolean removeRecipeMenu4(){
        if(kitchen.getIngredients().size() == 0){
            System.out.println("Add recipe first");
            return false;
        }
        System.out.println("Enter which recipe to remove");
        System.out.println(kitchen.printInfoRecipes());
        int recipeIndex = scanner.nextInt();
        if(inputLimitsCheck(1, kitchen.getRecipes().size(),recipeIndex)){
            System.out.println("Recipe is successfully removed");
            return kitchen.removeRecipeFromKitchen(kitchen.getRecipes().get(recipeIndex-1));
        } else { System.out.println("Invalid input"); return false;}
    }

    public void showIngredientsList5 (){
        if(kitchen.getIngredients().size() == 0){
            System.out.println("Add ingredients first");
            return;
        }
        System.out.println(kitchen.printInfoIngredients());
   }

   public void showRecipeList6 (){
       if(kitchen.getIngredients().size() == 0){
           System.out.println("Add recipe first");
           return;
       }
       System.out.println(kitchen.printInfoRecipes());
   }

   public boolean cookADish7(){
       if(kitchen.getIngredients().size() == 0){
           System.out.println("Add recipe first");
           return false;
       }
       System.out.println("Choose which recipe to cook");
       System.out.println(kitchen.printInfoRecipes());
       int recipeIndex = scanner.nextInt();
       System.out.println("How many to cook");
       if(inputLimitsCheck(1, kitchen.getRecipes().size(), recipeIndex) && kitchen.addDishToKitchen(kitchen.getRecipes().get(recipeIndex-1), scanner.nextInt())){
          System.out.println("Dish is successfully added");
          return true;
       } else { System.out.println("Invalid input "); return false; }
   }

   public void showReadyDishsList8(){
       if(kitchen.getIngredients().size() == 0){
           System.out.println("Cook a dish first");
           return;
       }
       System.out.println(kitchen.printInfoDishs());
   }

   public boolean modifyIngredientQuantityInKitchen9(){
       if(kitchen.getIngredients().size() == 0){
           System.out.println("Add ingredients first");
           return false;
       }
       System.out.println("Choose which ingredient to modify");
       System.out.println(kitchen.printInfoIngredients());
       int ingredientIndex = scanner.nextInt();
       if(ingredientIndex >= 1 && ingredientIndex <= kitchen.getIngredients().size()){
           System.out.println("Press 1 to increase ingredient quantity, 2 to decrease");
           switch (scanner.nextInt()){
               case 1:
                   System.out.println("Enter how much to add to the quantity");
                   kitchen.ingredientQuantityIncreaseFromUser(kitchen.getIngredients().get(ingredientIndex-1), scanner.nextDouble());
                   System.out.println("Quantity successfully decreased");
                   return true;
               case 2:
                   System.out.println("Enter how much to decrease the quantity");
                   kitchen.ingredientQuantityDecreaseFromUser(kitchen.getIngredients().get(ingredientIndex - 1), scanner.nextDouble());
                   System.out.println("Quantity successfully decreased");
                   return true;
           }

           System.out.println("Invalid input");
       }
       System.out.println("Invalid input");
       return false;
   }



   public boolean kitchenMenuCall(int input) {

           if(input > 0 && input <= 11){
               switch(input){
                   case 1:
                       this.addIngrdientMenu1();
                       return false;
                   case 2:
                       this.removeIngredientMenu2();
                       return false;
                   case 3:
                       this.addRecipeMenu3();
                       return false;
                   case 4:
                       this.removeRecipeMenu4();
                       return false;
                   case 5:
                       this.showIngredientsList5();
                       return false;
                   case 6:
                       this.showRecipeList6();
                       return false;
                   case 7:
                       this.cookADish7();
                       return false;
                   case 8:
                       this.showReadyDishsList8();
                       return false;
                   case 9:
                       this.modifyIngredientQuantityInKitchen9();
                       return false;
               }
           } else {
               System.out.println("Invalid input"); return false;}
        return true;
   }

    public boolean inputLimitsCheck(int lowEnd, int highEnd, int input){
        if (input >= lowEnd && input <= highEnd){
            return true;
        }
        return false;
    }



    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
