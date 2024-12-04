package dev.ducku.bankingproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String otherName;
    @Enumerated(EnumType.STRING)
    private GENDER gender;
    private String address;
    private String stateOfOrigin;
    private String accountNumber;
    private BigDecimal balance;
    private String phone;
    private String alternativePhone;
    private String email;
    @Enumerated(EnumType.STRING)
    private STATUS status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public enum GENDER {
        MALE, FEMALE, OTHER
    }

    public enum STATUS {
        ENABLED, DISABLED
    }
}
