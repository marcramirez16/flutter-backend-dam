package com.dam2.flutter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dam2.flutter.dao.CategoriesDAO;
import com.dam2.flutter.entity.Categories;

//metodos para retornar y actualizar datos de la categoria
@Service
public class CategoriesServiceImpl implements CategoriesService{
    @Autowired
    private CategoriesDAO cateogiresDAO;


    //RETORNA una lista de todas las categorias de la base de datos
    @Override
    public List<Categories> findAll() {
        return cateogiresDAO.findAll(); //findAll = metodo JpaRepository para listar todo
    }

    //RETORNA una categoria por su id, devuelve null si no existe
    @Override
    public Categories findById(Long id) {
        return cateogiresDAO.findById(id).orElse(null); //findById = metodo JpaRepository para buscar por id
    }

    //GUARDA una categoria en la base de datos
    @Override
    public Categories save(Categories Category) {
        return cateogiresDAO.save(Category); //save = metodo JpaRepository para guardar categoria
    }

    //ELIMINA una categoria por su id
    @Override
    public void deleteById(Long id) {
        cateogiresDAO.deleteById(id); //deleteById = metodo JpaRepository para borrar categoria por id
    }


}




