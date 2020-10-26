package result.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
