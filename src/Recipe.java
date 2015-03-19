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

    @Override
    public String toString(){
        String description = "Name of recipe " + nameOfRecipe + "\tQuantity of ingredients " + ingredients.size();
        for (int i = 0; i < ingredients.size(); i++) {
            description = String.join("", description, i+1 + ". " + ingredients.get(i) + "\n");
        }
        return description;
    }

    public boolean existanceCheckIngredientForRecipe(Ingredient ingredient){
        if(ingredient == null){
            return false;
        }
        return true;
    }
    public boolean addIngredient(Ingredient ingredient, double quantity){
        if(this.existanceCheckIngredientForRecipe(ingredient)){
        return ingredients.add(ingredient.cloneForRecipe(quantity));
        }
        return false;
    }
    public boolean removeIngredient (Ingredient ingredient){
        if(this.existanceCheckIngredientForRecipe(ingredient)){
        return ingredients.remove(ingredient);
        }
        return false;
    }
    public Recipe cloneForDish (Recipe recipe){
        return new Recipe(recipe.getNameOfRecipe());
    }
    public void modifyRecipeName(String nameOfRecipe){
        this.setNameOfRecipe(nameOfRecipe);
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


}
