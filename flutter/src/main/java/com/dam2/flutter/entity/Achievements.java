package com.dam2.flutter.entity;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;


@Entity //tabla conectada a la bd
@Table(name = "Achievements") //el nombre de la tabla es: "Achievements"
public class Achievements {

    //attributos de los objetivos

    @Id //identificador unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //el valor se incrementa automaticamente
    @Column(name = "id")
    private Long id;

    @Column(name = "categoryid") //la columna es categoryid
    private Long idCategory;

    @Column(name = "title") //la columna es title
    private String title;

    @Column(name = "description") //la columna es description
    private String description;

    //constructor1
    public Achievements() {
    }

    //constructor 2
    public Achievements(Long id, Long idCategory, String title, String description) {
        this.id = id;
        this.idCategory = idCategory;
        this.title = title;
        this.description = description;
    }

    
    //setters para agregar a la bd
    //getters para retornar los datos de la bd
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCategory() {
        return id;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //metodo tostring para imprimir los datos de el objetivo
    @Override
    public String toString() {
        return "Achievements [id=" + id + ", idCategory=" + idCategory +", title=" + title + ", description=" + description +"]";
    }

}


