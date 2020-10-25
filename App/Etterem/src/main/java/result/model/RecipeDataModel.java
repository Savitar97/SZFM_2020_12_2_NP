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
public class RecipeDataModel {

    @EmbeddedId
    private RecipeCompositeKey id;

    @Column(nullable = false)
    private Long amount;

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
