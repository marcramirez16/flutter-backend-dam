package com.dam2.flutter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dam2.flutter.entity.Users;

//ESTA CLASSE CONECTA EL USUARIO CON LA BD

@Repository //classe que gestiona la interaccion con la bd
//JpaRepository herramientas para buscar, guardar, eliminar y actualizar usuarios en la bd
//Users "objetos de tipo users"
//Long "tipo del identificador id de usuario"
public interface UsersDAO extends JpaRepository<Users, Long>{

}