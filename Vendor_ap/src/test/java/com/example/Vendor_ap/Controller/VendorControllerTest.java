package com.example.Vendor_ap.Controller;

import com.example.Vendor_ap.Entity.Vendor;
import com.example.Vendor_ap.Service.VendorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest
class VendorControllerTest {
    @Autowired
    VendorController vendorController;
@Autowired
    VendorService vendorService;
    @Test
    void createVendor() {
        // create a sample vendor object
        Vendor vendor = new Vendor("ayush","musawar","gorakhpur","uttarPradesh","1234","273158","6394528249","amaddheshiya2003@gmail.com");

        // mock the behavior of the vendor service's createVendor method
        when(vendorService.createVendor(any(Vendor.class))).thenReturn("Vendor created successfully");

        // call the createVendor method of the vendor controller with the sample vendor object
        ResponseEntity<String> response = vendorController.createVendor(vendor);

        // assert that the response status is 200 OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // assert that the response body is the expected message
        assertEquals("Vendor created successfully", response.getBody());
    }

    @Test
    void updateVendor() {
    }

    @Test
    void deleteVendor() {
    }

    @Test
    void getAllVendor() {
    }
}