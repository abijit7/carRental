package com.carRentalSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class VendorLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vendor-sequence")
    @SequenceGenerator(name = "vendor-sequence",sequenceName = "vendor-sequence",allocationSize = 1)
    private Long id;
    private String loginType ;

    private String email ;

    private String password ;

}
