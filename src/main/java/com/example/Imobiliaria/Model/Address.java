package com.example.Imobiliaria.Model;


import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name="addresses")
public class Address {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = true)
    private String number;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @OneToOne(mappedBy = "address")
    private Property property;



    
    /*Apenas é preciso especificar a relação em uma entidade, 
    nesse caso apenas dizemos qual atributo da classe "propriedade" estamos
    referenciando, no casso o objeto "adress" criado nela. */



    
}
