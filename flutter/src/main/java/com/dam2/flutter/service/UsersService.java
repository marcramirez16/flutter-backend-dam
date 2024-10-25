package com.dam2.flutter.service;

import java.util.List;
import com.dam2.flutter.entity.Users;

//interfaz con los metodos de UsersService que implementa los datos de la bd
public interface UsersService {

    List<Users> findAll();
    Users findById(Long id);
    Users save(Users user);
    void deleteById(Long id);
    void updateBiography(Long id, String biography);
    
}