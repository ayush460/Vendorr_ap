package com.example.Vendor_ap.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="vendor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendorId;
    private String vendorName;
    private String address;
    private String city;
    private String state;
    private String vendorCode;
    @NotNull
    @Size(min = 6, max = 6)
    private String pinCode;
    @NotNull
    @Size(min = 10, max = 10)
    private String mobileNumber;
    @Email(message = "Invalid email address")
    private String email;

    public Vendor(String vendorName, String address, String city, String state, String vendorCode, String pinCode, String mobileNumber, String email) {
        this.vendorName = vendorName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.vendorCode = vendorCode;
        this.pinCode = pinCode;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}

