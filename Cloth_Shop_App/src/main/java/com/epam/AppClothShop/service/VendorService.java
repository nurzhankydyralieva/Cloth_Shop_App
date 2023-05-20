package com.epam.AppClothShop.service;

import com.epam.AppClothShop.model.Vendor;

import java.util.List;

public interface VendorService {
    List<Vendor> getAllVendors();

    Vendor createVendor(Vendor vendor);

    Vendor getVendorById(Long id);

    void deleteVendorById(Long id);

    Vendor updateVendor(Vendor vendor);
}
