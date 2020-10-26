package result.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RecipeCompositeKey implements Serializable {

    @Column(name= "meal_id")
    private Long MealId;

    @Column(name = "ingredient_id")
    private Long IngredientId;

}
