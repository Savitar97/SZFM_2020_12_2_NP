package result.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="phone_number",nullable = false)
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="amount_of_people")
    private Long amountOfPeople;

    @Column(name="date",nullable = false)
    private ZonedDateTime date;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAmountOfPeople(Long amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public ObjectProperty<ZonedDateTime> getDateProperty() {
        return new SimpleObjectProperty<>(date);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getAmountOfPeople() {
        return amountOfPeople;
    }

    public ZonedDateTime getDate(){
        return date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
