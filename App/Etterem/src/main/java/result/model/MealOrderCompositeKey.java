package result.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class MealOrderCompositeKey implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="meal_id",referencedColumnName = "id")
    private MealDataModel meal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id",referencedColumnName = "id")
    private OrderDataModel order;
}
