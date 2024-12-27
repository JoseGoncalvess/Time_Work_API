package com.jgdev.timework.TimeWork.domain;

import jakarta.persistence.*;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nome;
    @Column(unique = true, nullable = false)
    String senha;
    @Column(unique = true, nullable = false)
    String matricula;

    int status;
}
