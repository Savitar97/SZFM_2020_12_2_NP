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
public class MealOrderDataModel {

    @EmbeddedId
    private MealOrderCompositeKey id;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private MealDataModel meal;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDataModel order;

    @Column(name ="amount", nullable = false)
    private Long amount;
}
