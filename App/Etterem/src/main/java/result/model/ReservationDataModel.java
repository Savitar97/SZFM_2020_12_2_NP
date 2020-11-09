package result.model;

import com.sun.javafx.binding.StringFormatter;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="phone_number",nullable = false)
    private Long phoneNumber;

    @Column(name="amount_of_people")
    private Long amountOfPeople;

    @Column(name="date",nullable = false)
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
