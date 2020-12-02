package result.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RecipeCompositeKey implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_id")
    private MealDataModel meal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id",referencedColumnName = "name")
    private IngredientDataModel ingredient;

    public MealDataModel getMeal() {
        return meal;
    }

    public void setMeal(MealDataModel meal) {
        this.meal = meal;
    }

    public IngredientDataModel getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDataModel ingredient) {
        this.ingredient = ingredient;
    }
}
