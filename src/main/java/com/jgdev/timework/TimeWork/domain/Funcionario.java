package com.jgdev.timework.TimeWork.domain;

import jakarta.persistence.*;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(unique = true, nullable = false)
    String password;
    @Column(unique = true, nullable = false)
    String matricula;

    @Column(unique = false, nullable = true)
    String telefone;
    @Column(unique = true, nullable = true)
    String email;

    @Column(unique = false, nullable = true)
    String cargo;



    @OneToOne
    Enterprise Enterprise;

    int status;

    public Funcionario() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNome(String nome) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public Enterprise getEnterprise() {
        return Enterprise;
    }

    public void setEnterprise( Enterprise enterprise) {
        Enterprise = enterprise;
    }



}
