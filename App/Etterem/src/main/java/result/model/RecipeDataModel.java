package result.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RecipeDataModel {

    @EmbeddedId
    private RecipeCompositeKey id;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private MealDataModel meal;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientDataModel ingredient;

    @Column(name="amount",nullable = false)
    private Long amount;

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
