package edu.uptc.swii.usermicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @Column(name = "id_user")
    private String idUser;
    @Column(name="name_user")
    private String nameUser;
    @Column(name="last_name_user")
    private String lastNameUser;
    private String address;
    private String email;
    private String organizationUser;

    private Integer idUserType;


}
