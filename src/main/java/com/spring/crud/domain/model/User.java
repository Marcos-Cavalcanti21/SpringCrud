package com.spring.crud.domain.model;

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
    private boolean admin;
    private String email;
    private String password;
    private String role;

}
