package com.dam2.flutter.dao;

import com.dam2.flutter.entity.Achievements;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ESTA CLASSE CONECTA EL OBJETIVO CON LA BD

@Repository //classe que gestiona la interaccion con la bd
//JpaRepository herramientas para buscar, guardar, eliminar y actualizar objetivos en la bd
//Achievements "objetos de tipo objetivos"
//Long "tipo del identificador id de objetivo"
public interface AchievementsDAO extends JpaRepository<Achievements, Long>{
    List<Achievements> findByCategoryid(Long categoryid);

    @Query("SELECT a FROM Achievements a WHERE LOWER(a.title) LIKE LOWER(CONCAT('%', :text, '%')) " +
    "OR LOWER(a.description) LIKE LOWER(CONCAT('%', :text, '%'))")
    List<Achievements> findByTitleOrDescriptionContaining(@Param("text") String text);

}


