package com.example.Vendor_ap.Controller;

import com.example.Vendor_ap.Entity.Vendor;
import com.example.Vendor_ap.Repository.VendorRepository;
import com.example.Vendor_ap.Service.VendorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class VendorControllerTest {
    @Mock
    private VendorService vendorService;

    @InjectMocks
    private VendorController vendorController;
    @Test
    void createVendor() {
        Vendor vendor = new Vendor();
        vendor.setVendorName("John Doe");
        when(vendorService.createVendor(vendor)).thenReturn("Vendor created successfully");

        // When
        ResponseEntity<String> responseEntity = vendorController.createVendor(vendor);

        // Then
        verify(vendorService).createVendor(vendor);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Vendor created successfully", responseEntity.getBody());
    }

    @Test
    public void testCreateVendorError() {
        // Given
        Vendor vendor = new Vendor();
        vendor.setVendorName("John Doe");
        when(vendorService.createVendor(vendor)).thenThrow(new RuntimeException());

        // When
        ResponseEntity<String> responseEntity = vendorController.createVendor(vendor);

        // Then
        verify(vendorService).createVendor(vendor);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Error creating vendor", responseEntity.getBody());
    }



    @Test
    void updateVendor() {
        int vendorId = 1;
        Vendor vendor = new Vendor();
        vendor.setVendorName("John Doe");
        when(vendorService.updateVendor(vendorId, vendor)).thenReturn("Vendor updated successfully");

        // When
        ResponseEntity<String> responseEntity = vendorController.updateVendor(vendorId, vendor);

        // Then
        verify(vendorService).updateVendor(vendorId, vendor);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Vendor updated successfully", responseEntity.getBody());
    }

    @Test
    public void testUpdateVendorNotFound() {
        // Given
        int vendorId = 1;
        Vendor vendor = new Vendor();
        vendor.setVendorName("John Doe");
        when(vendorService.updateVendor(vendorId, vendor)).thenThrow(new NoSuchElementException());

        // When
        ResponseEntity<String> responseEntity = vendorController.updateVendor(vendorId, vendor);

        // Then
        verify(vendorService).updateVendor(vendorId, vendor);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    public void testUpdateVendorError() {
        // Given
        int vendorId = 1;
        Vendor vendor = new Vendor();
        vendor.setVendorName("John Doe");
        when(vendorService.updateVendor(vendorId, vendor)).thenThrow(new RuntimeException());

        // When
        ResponseEntity<String> responseEntity = vendorController.updateVendor(vendorId, vendor);

        // Then
        verify(vendorService).updateVendor(vendorId, vendor);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Error updating vendor", responseEntity.getBody());
    }



    @Test
    void deleteVendor() {
        int vendorId = 1;
        doNothing().when(vendorService).deleteVendor(vendorId);

        ResponseEntity<String> response = vendorController.deleteVendor(vendorId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Vendor deleted successfully", response.getBody());
    }

    @Test
    public void testDeleteVendorNotFound() {
        int vendorId = 1;
        doThrow(new EmptyResultDataAccessException(1)).when(vendorService).deleteVendor(vendorId);

        ResponseEntity<String> response = vendorController.deleteVendor(vendorId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testDeleteVendorError() {
        int vendorId = 1;
        doThrow(new RuntimeException()).when(vendorService).deleteVendor(vendorId);

        ResponseEntity<String> response = vendorController.deleteVendor(vendorId);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Error deleting vendor", response.getBody());
    }



    @Test
    void getAllVendor() {
        List<Vendor> vendors = Arrays.asList(new Vendor(), new Vendor());
        when(vendorService.getAllVendors()).thenReturn(vendors);

        ResponseEntity<List<Vendor>> response = vendorController.getAllVendor();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(vendors, response.getBody());
    }

    @Test
    public void testGetAllVendorNoContent() {
        when(vendorService.getAllVendors()).thenReturn(Collections.emptyList());

        ResponseEntity<List<Vendor>> response = vendorController.getAllVendor();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
    }

}
