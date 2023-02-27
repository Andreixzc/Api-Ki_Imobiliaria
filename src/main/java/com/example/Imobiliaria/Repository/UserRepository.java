package com.example.Imobiliaria.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Imobiliaria.Model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}
