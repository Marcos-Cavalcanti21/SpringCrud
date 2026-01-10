package com.spring.crud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity //Transforma a Classe em Tabela no Banco
@Table(name = "Users") //Da nome a Tabela no Banco
@Getter
@Setter
@NoArgsConstructor //Cria o Constructor sem os Argumentos
@AllArgsConstructor //Cria o Constructor agora com os Argumentos
public class User {

    @Id //Expecifica a PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gera o valor do ID
    private Long id;

    private String name;
    private String email;

//    public User() {}
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
