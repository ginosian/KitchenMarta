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
        System.out.println("7. Show recipes description");
        System.out.println("8. Cook a dish");
        System.out.println("9. Show ready dishes list");
        System.out.println("10. Modify ingredient quantity in kitchen");
        System.out.println("11. Modify recipe");
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
        return false;
    }

    public boolean addRecipeMenu3(){
        return false;
    }

    public boolean removeRecipeMenu4(){
        return false;
    }

    public void showIngredientsList5 (){
        System.out.println(kitchen.printInfoIngredients());
   }

   public void showRecipeList6 (){
       System.out.println(kitchen.printInfoRecipes());
   }

   public void showRecipeDescription7(){

   }

   public boolean cookADish8(){
       return false;
   }

   public void showReadyDishsList9(){
       System.out.println(kitchen.printInfoDishs());
   }

   public boolean modifyIngredientQuantityInKitchen10(){
       return false;
   }

   public boolean modifyRecipe11(){
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
                       this.showRecipeDescription7();
                       return false;
                   case 8:
                       this.cookADish8();
                       return false;
                   case 9:
                       this.showReadyDishsList9();
                       return false;
                   case 10:
                       this.modifyIngredientQuantityInKitchen10();
                       return false;
                   case 11:
                       this.modifyRecipe11();
                       return false;
               }
           } else {
               System.out.println("Invalid input"); return false;}
        return true;
   }





    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
