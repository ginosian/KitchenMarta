/**
 * Created by Martha on 18.03.15.
 */
public class Dish {
    private String name;
    int quantity;

    public Dish(String name) {
        this.name = name;
        this.quantity = quantity;
    }

    public Recipe cloneForDish(String name, Recipe recipe, int quantity){
        this.name = name;
        this.quantity = quantity;
        return new Recipe (recipe.getNameOfRecipe());
    }

    public boolean recipeCheck(Recipe recipe){
        if (recipe.getIngredients().size() != 0){
            return true;
        }
        return false;
    }

    public boolean ingrdientQuantityCheck(Recipe recipe){
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            if(recipe.getIngredients().get(i).getQuantity()<)
        }
    }

    // region Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // endregion
}
