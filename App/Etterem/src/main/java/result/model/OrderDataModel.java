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
public class OrderDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="phone_number",nullable = false)
    private Long phoneNumber;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="method_of_payment",nullable = false)
    private String methodOfPayment;

    @Column(name="comment")
    private String comment;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
