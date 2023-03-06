package com.example.Vendor_ap.Repository;

import com.example.Vendor_ap.Entity.Vendor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class VendorRepositoryTest {

    @Autowired
    private VendorRepository vendorRepository;

    @Test
    public void testFindByVendorCode() {
        // given
        Vendor vendor = new Vendor();
        vendor.setVendorCode("V001");
        vendorRepository.save(vendor);

        // when
        Vendor result = vendorRepository.findByVendorCode("V001");

        // then
        assertNotNull(result);
        assertEquals(vendor.getVendorId(), result.getVendorId());
        assertEquals(vendor.getVendorCode(), result.getVendorCode());
    }
}