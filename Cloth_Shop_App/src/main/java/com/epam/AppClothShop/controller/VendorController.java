package com.epam.AppClothShop.controller;

import com.epam.AppClothShop.model.Vendor;
import com.epam.AppClothShop.service.VendorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
@SecurityRequirement(name = "clothShopApi")
public class VendorController {

    private VendorService service;

    @Autowired
    public VendorController(VendorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return service.getAllVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable Long id) {
        return service.getVendorById(id);
    }

    @PostMapping("/save")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return service.createVendor(vendor);
    }

    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        vendor.setId(id);
        return service.updateVendor(vendor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Long id) {
        service.deleteVendorById(id);
    }
}
