package result.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReservationDataModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long phoneNumber;

    @Column
    private Long amountOfPeople;

    @Column(nullable = false)
    private ZonedDateTime date;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAmountOfPeople(Long amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }
}
