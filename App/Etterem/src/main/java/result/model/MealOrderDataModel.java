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


    @Column(name ="amount", nullable = false)
    private Long amount;
}
