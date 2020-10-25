package result.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MealOrderCompositeKey implements Serializable {

    @Column
    private Long MealId;

    @Column
    private Long OrderId;
}
