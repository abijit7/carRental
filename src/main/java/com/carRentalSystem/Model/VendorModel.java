package com.carRentalSystem.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorModel {
    private Long id;
    @NotNull(message = "Login type should not be null")
    private String loginType;
    private String firstName;
    private String lastName;
    @Email
    @NotEmpty(message = "Email address should not be empty")
    private String email;
    @Size(min = 10 , max = 10)
    @NotEmpty
    private String mobileNumber;
    @NotEmpty(message = "password should not be empty")
    private String password;
    @NotEmpty(message = "confirm password should not be empty")
    private String confirmPassword;
    @Size(min = 10,max = 10,message = "Invalid license Number")
    @Pattern(regexp = "^RDS.*", message = "Invalid License Number ")
    private String licenseNumber;
    @Size(min = 10,max = 10,message = "Invalid Registration Number")
    @Pattern(regexp =".*ERT$" , message = "Invalid Registration Number")
    private String registrationNo;
    @NotEmpty(message = "status required")
    private String status ;
    private List<CarModel> carModels = new ArrayList<>();

    public VendorModel(long l, String firstName, String abijit, String pariyar, String mail, String number, String number1, String rds1234567, String registrationNo, String a) {
    }
}
