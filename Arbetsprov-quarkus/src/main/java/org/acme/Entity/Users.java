package org.acme.Entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;


//Sätter våra konstruktörer både en tom och en med alla attribut
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Users extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String address;

    public String email;

    public String telephone;

}
