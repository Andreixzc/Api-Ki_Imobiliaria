package com.example.Imobiliaria.Model;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
//@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
//one to many seria um array na entidade 'one'?
public class User {
    public User (){
        this.setActive(true);
    }
    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private boolean isADM;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdAt;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "id")//Nome da chave primaria que vai ser ligada na hora de juntar as colunas
    private List <Schedule> u;
    //Array de userProperties, pois um usuario pode conter diversas user properties
}
