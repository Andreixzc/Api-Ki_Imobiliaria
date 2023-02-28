package com.example.Imobiliaria.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Imobiliaria.Model.Address;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    
}
