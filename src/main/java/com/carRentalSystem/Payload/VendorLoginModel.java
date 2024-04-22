package com.carRentalSystem.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorLoginModel {
    private Long id;
    private String loginType ;

    private String email ;

    private String password ;
}
