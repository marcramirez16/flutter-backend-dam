package com.dam2.flutter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam2.flutter.entity.Categories;

//ESTA CLASSE CONECTA LA CATEGORIA CON LA BD

@Repository //classe que gestiona la interaccion con la bd
//JpaRepository herramientas para buscar, guardar, eliminar y actualizar categorias en la bd
//categories "objetos de tipo categories"
//Long "tipo del identificador id de categoria"
public interface CategoriesDAO extends JpaRepository<Categories, Long>{
    
}

