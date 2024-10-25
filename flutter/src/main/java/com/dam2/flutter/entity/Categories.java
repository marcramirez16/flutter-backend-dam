package com.dam2.flutter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //tabla conectada a la bd
@Table(name = "Categories") //el nombre de la tabla es: "Categories"
public class Categories {

    //attributos de las Categorias

    @Id //identificador unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //el valor se incrementa automaticamente
    @Column(name = "id") //el nombre de la columna es "id"
    private Long id;

    @Column(name = "name") //el nombre de la columna es "name"
    private String name;

    @Column(name = "icon") //el nombre de la columna es "icon"
    private String icon;
    
    //constructor1
    public Categories() {
    }

    //constructor 2
    public Categories(Long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    //setters para agregar a la bd
    //getters para retornar los datos de la bd
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    //metodo tostring para imprimir los datos de la categoria
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name +"]";
    }
}