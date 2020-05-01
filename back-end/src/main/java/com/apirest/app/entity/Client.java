package com.apirest.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idClient;

    private String name;

    private String email;

    private int age;

    private short genre;

    public Client() {
    }

    public Client(int idClient, String name, String email, int age, short genre) {
        this.idClient = idClient;
        this.name = name;
        this.email = email;
        this.age = age;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public short getGenre() {
        return genre;
    }

    public void setGenre(short genre) {
        this.genre = genre;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
} // end entity
