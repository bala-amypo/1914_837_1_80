package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "user_accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String role;
    private String department;
    private LocalDateTime createdAt;
    public UserAccount() {}
    public UserAccount(Long id, String fullName, String email, String password,String role, String department, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
