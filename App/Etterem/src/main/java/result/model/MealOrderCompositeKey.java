package result.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class MealOrderCompositeKey implements Serializable {

    @Column(name="meal_id", nullable = false)
    private Long MealId;

    @Column(name="order_id", nullable = false)
    private Long OrderId;
}
