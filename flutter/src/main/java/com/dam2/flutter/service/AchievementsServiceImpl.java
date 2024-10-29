package com.dam2.flutter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dam2.flutter.dao.AchievementsDAO;
import com.dam2.flutter.dao.CategoriesDAO;
import com.dam2.flutter.entity.Achievements;
import com.dam2.flutter.entity.Categories;


//metodos para retornar y actualizar datos de el objetivo
@Service
public class AchievementsServiceImpl implements AchievementsService {
    @Autowired
    private AchievementsDAO achievementsDAO;


    //RETORNA una lista de todos los objetivos de la categoria
    @Override
    public List<Achievements> findByCategoryId(Long categoryid) {
        return achievementsDAO.findByCategoryId(categoryid); 
    }


    //RETORNA un objetivo por su id, devuelve null si no existe
    @Override
    public Achievements findById(Long id) {
        return achievementsDAO.findById(id).orElse(null); //findById = metodo JpaRepository para buscar por id
    }

    //GUARDA un objetivo en la base de datos
    @Override
    public Achievements save(Achievements achievements) {
        return achievementsDAO.save(achievements); //save = metodo JpaRepository para guardar objetivo
    }

    
    //ELIMINA un objetivo por su id
    @Override
    public void deleteById(Long id) {
        achievementsDAO.deleteById(id); //deleteById = metodo JpaRepository para borrar objetivo por id
    }
}





