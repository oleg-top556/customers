package com.test.customers.entity;


import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "customer")
@SQLDelete(sql = "update customer set is_active = 0 where id =?")
@Where(clause = "is_active = 1")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created")
    private Long created;

    @Column(name = "updated")
    private Long updated;

    @NotEmpty
    @Column(name = "full_name")
    @Size(min = 2, max = 50, message = "Full name need to have 2..50 chars")
    private String fullName;

    @NotEmpty
    @Column(name = "email")
    @Email(message = "Email need to have 2..100 chars")
    @Size(min = 2, max = 100, message = "Email need to have 2..100 chars" )
    @NotBlank
    private String email;

    @NotEmpty
    @Size(min = 6, max = 14, message = "Phone need to have 6..14 chars, only digits, should start from +")
    @Column(name = "phone")
    @Pattern(regexp = "^(\\+)+[1-9]+[0-9]*$", message = "Phone need to have 6..14 chars, only digits, should start from +")
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive = Boolean.FALSE;

    public Customer() {
    }

    public Customer(Long created, Long updated, String fullName, String email, String phone, Boolean isActive) {
        this.created = created;
        this.updated = updated;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
