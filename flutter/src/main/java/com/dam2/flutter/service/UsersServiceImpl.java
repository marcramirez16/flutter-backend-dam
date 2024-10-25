package com.dam2.flutter.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dam2.flutter.dao.UsersDAO;
import com.dam2.flutter.entity.Users;

//metodos para retornar y actualizar datos del usuario
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    //RETORNA una lista de todos los usuarios de la base de datos
    @Override
    public List<Users> findAll() {
        return usersDAO.findAll(); //findAll = metodo JpaRepository para listar todo
    }

    //RETORNA un usuario por su id, devuelve null si no existe
    @Override
    public Users findById(Long id) {
        return usersDAO.findById(id).orElse(null); //findById = metodo JpaRepository para buscar por id
    }

    //GUARDA un usuario en la base de datos
    @Override
    public Users save(Users user) {
        return usersDAO.save(user); //save = metodo JpaRepository para guardar usuario
    }

    //ELIMINA un usuario por su id
    @Override
    public void deleteById(Long id) {
        usersDAO.deleteById(id); //deleteById = metodo JpaRepository para borrar usuario por id
    }

    //ACTUALIZA la biographya del usuario
    @Override
    public void updateBiography(Long id, String biography) {
        Users user = usersDAO.findById(id).orElse(null); //crear objeto usuario buscado por el id con JpaRepository
        if (user != null) {
            user.setBiography(biography);  //setBiography = metodo JpaRepository para cambiar el valor biographia del usuario
            usersDAO.save(user); //metodo JpaRepository para guardar el usuario
            System.out.println("Biography updated successfully for user id: " + id);
        } else {
            System.out.println("User with id " + id + " not found");
        }
    }
}
