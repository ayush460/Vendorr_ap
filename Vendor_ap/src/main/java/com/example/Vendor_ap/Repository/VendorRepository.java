package com.example.Vendor_ap.Repository;

import com.example.Vendor_ap.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VendorRepository extends JpaRepository<Vendor,Integer> {

    Vendor findByVendorCode(String vendorCode);
}
