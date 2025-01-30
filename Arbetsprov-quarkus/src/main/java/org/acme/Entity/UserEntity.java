package org.acme.Entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.acme.DTO.User;


//Sätter våra konstruktörer både en tom och en med alla attribut

@Entity
public class UserEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String name;

    @Column
    public String address;

    @Column
    public String email;

    @Column
    public String telephone;

    public UserEntity() {

    }

    public UserEntity(User user) {
        this.address = user.address;
        this.name = user.name;
        this.email = user.email;
        this.telephone = user.telephone;
    }
}
