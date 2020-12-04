package result.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RecipeDataModel {

    @EmbeddedId
    private RecipeCompositeKey id;

    @Column(name="amount",nullable = false)
    private Long amount;

    @Column(name="unit",nullable = false)
    private String unit;
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private IngredientDataModel ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mealId")
    @JoinColumn(name = "meal_id")
    private MealDataModel meal;
    */
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public RecipeDataModel(Long amount, String unit, IngredientDataModel ingredient, MealDataModel meal) {
        this.id=new RecipeCompositeKey(ingredient.getId(),meal.getId());
        this.amount = amount;
        this.unit = unit;
    }
}
