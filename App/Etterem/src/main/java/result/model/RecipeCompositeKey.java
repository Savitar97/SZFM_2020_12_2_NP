package result.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RecipeCompositeKey implements Serializable {

    @Column
    private Long MealId;

    @Column
    private Long IngredientId;
    
}
