package com.example.Imobiliaria.Model;

import java.util.List;
import java.util.UUID;
import org.hibernate.validator.constraints.UniqueElements;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="categories")
public class Category {
    @Id
    private UUID id;
    @UniqueElements
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "id")
    private List<Property> properties;
    
    
}
