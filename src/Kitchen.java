import java.util.ArrayList;

/**
 * Created by Martha on 19.03.15.
 */
public class Kitchen {
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Recipe> recipes;
    private ArrayList<Dish> dishs;

    public Kitchen() {
        this.ingredients = new ArrayList<Ingredient>();
        this.recipes = new ArrayList<Recipe>();
        this.dishs = new ArrayList<Dish>();
    }

    public boolean existanceCheckIngredient(Ingredient ingredient){
        if(ingredient == null){
            return false;
        }
        return true;
    }

    public boolean existanceCheckIngredientsSize(){
        if (ingredients.size() == 0){
            return false;
        }
        return true;
    }

    public boolean existanceCheckRecipe(Recipe recipe){
        if(recipe == null){
            return false;
        }
        return true;
    }

    public boolean existanceCheckRecipesSize(){
        if(recipes.size() == 0){
            return false;
        }
        return true;
    }

    public boolean existanceCheckDish (Dish dish){
        if (dish == null){
            return false;
        }
        return true;
    }

    public boolean existanceCheckDishsSize(){
        if (dishs.size() == 0){
            return false;
        }
        return true;
    }
     public boolean addIngredientInKitchen(Ingredient ingredient){
         if(this.existanceCheckIngredient(ingredient)){
            return ingredients.add(ingredient);
         }
         return false;
     }

    public boolean containsIngredientInKitchen(Ingredient ingredient){
        if(this.existanceCheckIngredient(ingredient) && this.existanceCheckIngredientsSize()){
            for (int i = 0; i < ingredients.size(); i++) {
                return ingredients.get(i).getName().equals(ingredient.getName());
            }
        }
        return false;
    }

    public Ingredient returnsContainingIngredientInKitchen(Ingredient ingredient){
        if(this.existanceCheckIngredient(ingredient) && this.existanceCheckIngredientsSize() && this.containsIngredientInKitchen(ingredient)){
            for (int i = 0; i < ingredients.size(); i++) {
                if(ingredients.get(i).getName().equals(ingredient.getName())){
                    return ingredients.get(i);
                }
            }
        }
        return null;
    }
    public boolean removeIngredientFromKitchen(Ingredient ingredient){
        if(this.existanceCheckIngredient(ingredient) && this.existanceCheckIngredientsSize() && this.containsIngredientInKitchen(ingredient)){
            return this.ingredients.remove(ingredient);
            }
        return false;
    }

    public boolean ingredientQuantityCheckForDish(Dish dish){
        if(this.existanceCheckIngredientsSize() && this.existanceCheckDish(dish)){
            for (int i = 0; i < dish.getRecipe().getIngredients().size() ; i++) {
                  return this.returnsContainingIngredientInKitchen(dish.getRecipe().getIngredients().get(i)).getQuantity()
                          >= dish.getRecipe().getIngredients().get(i).getQuantity();
            }

        }
        return false;
    }

    public boolean ingredientQuantityDecrease(Ingredient ingredient){
        if(this.existanceCheckIngredient(ingredient) && this.containsIngredientInKitchen(ingredient)){
              this.returnsContainingIngredientInKitchen(ingredient).setQuantity(returnsContainingIngredientInKitchen(ingredient).getQuantity() - ingredient.getQuantity());
            return true;
            }
        return false;
    }

    public boolean ingredientQuantityIncrease(Ingredient ingredient){
        if(this.existanceCheckIngredient(ingredient) && this.containsIngredientInKitchen(ingredient)){
            this.returnsContainingIngredientInKitchen(ingredient).setQuantity(returnsContainingIngredientInKitchen(ingredient).getQuantity() + ingredient.getQuantity());
            return true;
        }
        return false;
    }

    public boolean addDishToKitchen(Dish dish){
        if(this.existanceCheckDish(dish) && this.ingredientQuantityCheckForDish(dish)){
            if(dishs.add(dish)){
                for (int i = 0; i < dish.getRecipe().getIngredients().size(); i++) {
                    return this.ingredientQuantityDecrease(dish.getRecipe().getIngredients().get(i));
                }
            }
        }
        return false;
    }

    public boolean addRecipeToKitchen(Recipe recipe){
        if(this.existanceCheckRecipe()){
            return true
        }
    }
    // region Setters and Getters

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public ArrayList<Dish> getDishs() {
        return dishs;
    }

    public void setDishs(ArrayList<Dish> dishs) {
        this.dishs = dishs;
    }
    // endregion
}