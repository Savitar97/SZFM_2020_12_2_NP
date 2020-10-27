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
public class IngredientDataModel {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "unit",nullable = false)
    private String unit;


    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
