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

    @Column(name="amount",nullable = false)
    private Long amount;

    @Column(name="amount",nullable = false)
    private String unit;

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
