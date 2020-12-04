package result.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class RecipeCompositeKey implements Serializable {

    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "meal_id")
    private Long mealId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeCompositeKey)) return false;
        RecipeCompositeKey that = (RecipeCompositeKey) o;
        return ingredientId.equals(that.ingredientId) &&
                mealId.equals(that.mealId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, mealId);
    }
}
