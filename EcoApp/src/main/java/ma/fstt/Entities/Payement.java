package ma.fstt.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payments")
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order; // Represents the order associated with this payment

    private Date paymentDate;
    private double totalAmount;

    public Payement() {
    }

    public Payement(int id, Order order, Date paymentDate, double totalAmount) {
        this.id = id;
        this.order = order;
        this.paymentDate = paymentDate;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

