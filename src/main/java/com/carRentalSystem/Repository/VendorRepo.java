package com.carRentalSystem.Repository;

import com.carRentalSystem.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor,Long> {

Vendor findByEmail(String email);
}
