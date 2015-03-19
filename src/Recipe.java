import java.util.ArrayList;

/**
 * Created by Martha on 18.03.15.
 */
public class Recipe {
    private String nameOfRecipe;
    private ArrayList<Ingredient> ingredients;

    public Recipe(String nameOfRecipe) {
        this.nameOfRecipe = nameOfRecipe;
        this.ingredients = new ArrayList<Ingredient>();
    }

    public boolean containsIngredient(Ingredient ingredient){
        for (int i = 0; i < this.ingredients.size(); i++) {
            if (ingredients.get(i).getName().equals(ingredient.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean addIngredient(Ingredient ingredient, double quantity){
        if (ingredients.add(ingredient.cloneForRecipe(quantity))){
            return true;
        }
       return false;
    }
    public boolean removeIngredient (Ingredient ingredient){
        if(ingredients.remove(ingredient)){
            return true;
        }
        return false;
    }

    public boolean ingredientQuantityCheck(){
        for (int i = 0; i < ingredients.size(); i++) {
            if(this.getIngredients().get(i).getName().equals(i))
        }
    }


    // region Setters and Getters
    public String getNameOfRecipe() {
        return nameOfRecipe;
    }

    public void setNameOfRecipe(String nameOfRecipe) {
        this.nameOfRecipe = nameOfRecipe;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    // endregion
    sou

}
