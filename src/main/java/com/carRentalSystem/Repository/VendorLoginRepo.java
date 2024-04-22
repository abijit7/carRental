package com.carRentalSystem.Repository;

import com.carRentalSystem.Entity.VendorLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorLoginRepo extends JpaRepository<VendorLogin,Long> {
}
