package result.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RecipeDataModel {

    @EmbeddedId
    private RecipeCompositeKey id;

    @Column(name="amount",nullable = false)
    private Long amount;

    @Column(name="unit",nullable = false)
    private String unit;

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setIngredient(IngredientDataModel ingredient){
        this.id.setIngredient(ingredient);
    }

    public void setMeal(MealDataModel meal){
        this.id.setMeal(meal);
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
