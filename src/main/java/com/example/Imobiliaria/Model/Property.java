package com.example.Imobiliaria.Model;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "properties", uniqueConstraints = {@UniqueConstraint(columnNames = {"addressID"})})
public class Property {
    @Id
    private UUID id;
    private boolean sold;

    @Column(nullable = false)
    private float value;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdAt;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "id")
    private List<Schedule> Schedule;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    /*
     * OneToOne: O cascade significa que ao criarmos um registro dessa entidade, iremos criar também
     * um registro na entidade que ela se relaciona. A mesma coisa ao deletarmos ela. Primeiramente,
     * damos o joinColumn passando o nome da chave primaria da tabela que queremos juntar, no casso
     * "adressID"(chave primaria da tabela endereço), em seguida criamos o atributo Adress.
     */


}
