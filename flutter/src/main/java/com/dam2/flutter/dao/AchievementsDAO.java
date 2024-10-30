package com.dam2.flutter.dao;

import com.dam2.flutter.entity.Achievements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;



import java.util.List;


//ESTA CLASSE CONECTA EL OBJETIVO CON LA BD

@Repository //classe que gestiona la interaccion con la bd
//JpaRepository herramientas para buscar, guardar, eliminar y actualizar objetivos en la bd
//Achievements "objetos de tipo objetivos"
//Long "tipo del identificador id de objetivo"
public interface AchievementsDAO extends JpaRepository<Achievements, Long>{
    List<Achievements> findByCategoryid(Long categoryid);

    //@Query("SELECT a.title, a.description FROM Achievements a WHERE a.categoryid= :categoryid")
    //List<Achievements> findByCategoryId(@Param("categoryid") Long categoryid);
    
}


