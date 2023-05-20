package com.epam.AppClothShop.repository;

import com.epam.AppClothShop.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
