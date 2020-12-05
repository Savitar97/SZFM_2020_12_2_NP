package result.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RecipeDataModel implements Serializable {

    /*
    @EmbeddedId
    private RecipeCompositeKey id;
    */
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    */
    @Id
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id", nullable = false,referencedColumnName = "ID")
    private IngredientDataModel ingredient;

    @Id
    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @MapsId("mealId")
    @JoinColumn(name = "meal_id", nullable = false,referencedColumnName = "ID")
    private MealDataModel meal;

    @Column(name="amount",nullable = false)
    private Long amount;

    @Column(name="unit",nullable = false)
    private String unit;


    public IngredientDataModel getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDataModel ingredient) {
        this.ingredient = ingredient;
    }

    public MealDataModel getMeal() {
        return meal;
    }

    public void setMeal(MealDataModel meal) {
        this.meal = meal;
    }

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

    public String getIngredientName(){
        return this.ingredient.getName();
    }
}
