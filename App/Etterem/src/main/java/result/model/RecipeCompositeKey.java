package result.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RecipeCompositeKey implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_id")
    private MealDataModel meal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id",referencedColumnName = "id")
    private IngredientDataModel ingredient;

}
