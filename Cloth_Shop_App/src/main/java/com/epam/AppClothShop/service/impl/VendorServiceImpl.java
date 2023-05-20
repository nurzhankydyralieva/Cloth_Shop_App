package com.epam.AppClothShop.service.impl;

import com.epam.AppClothShop.model.Vendor;
import com.epam.AppClothShop.repository.VendorRepository;
import com.epam.AppClothShop.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VendorServiceImpl implements VendorService {
    @Autowired
    private VendorRepository repository;

    @Override
    public List<Vendor> getAllVendors() {
        return repository.findAll();
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        return repository.save(vendor);
    }

    @Override
    public Vendor getVendorById(Long id) {
        Optional<Vendor> vendor = repository.findById(id);
        if (vendor.isPresent()) {
            return vendor.get();
        }
        throw new RuntimeException("Vendor with id " + id + " not found");
    }

    @Override
    public void deleteVendorById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Vendor updateVendor(Vendor vendor) {
        return repository.save(vendor);
    }
}
