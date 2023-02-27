package com.example.Imobiliaria.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Imobiliaria.Model.Adress;

public interface AdressRepository extends JpaRepository<Adress, UUID> {
    
}
