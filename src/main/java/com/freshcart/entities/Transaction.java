package com.freshcart.entities;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String paymentMethod; // CARD, UPI, COD
    private String paymentStatus; // SUCCESS, FAILED, PENDING

    private double amount;
    private LocalDateTime paymentDate;
}
