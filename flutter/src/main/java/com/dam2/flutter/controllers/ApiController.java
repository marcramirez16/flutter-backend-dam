package com.dam2.flutter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dam2.flutter.entity.Achievements;
import com.dam2.flutter.entity.Categories;
import com.dam2.flutter.entity.Users;
import com.dam2.flutter.service.CategoriesService;
import com.dam2.flutter.service.UsersService;
import com.dam2.flutter.service.AchievementsService;


//EN ESTA CLASSE ESTARAN TODOS LOS METODOS UTILES PARA EDITAR EDITAR USUARIOS Y DIRIGRLOS A LAS BD O AL CONTRARIO

@RestController //indica que la classe maneja solicitudes http y sus datos devolveran datos en lenguaje de marcas json
//ESTA CLASSE MANEJA LAS PETICIONES HTTP
public class ApiController {

    //objeto para guardar el usuario
    @Autowired //inyeccion de dependencias
    private UsersService usersService; //objeto de la interfaz UsersService "tendra los atributos de la classe User desde userdao..."
    
    //objeto para guradar la categoria
    @Autowired //inyeccion de depnendencias
    private CategoriesService categoriesService; //objeto de la interfaz CategoriesService "tendra los atributos de la classe Categories desde categoriesdao..."

    //objeto para guardar los objetivos
    @Autowired //inyeccion de dependencias
    private AchievementsService achievementsService; //objeto de la interfaz AchievementsService "tendra los atributos de la classe Achievements desde achivementsdao..."

//USUARIOS!!----------------------------------------------------------------------------------------

// metodo para retornar usuario
    @GetMapping("/users") //GetMapping devuelve una lista de
    public List<Users> findAllUsers() {
        return usersService.findAll(); //metodo para retornar
    }
    
// guardar nuevo usuario
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users newUser) { //pasar nuevo usuario
        return usersService.save(newUser); //metodo para guardar un nuevo usuario
    }

// borrar usuario
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) { //pasar id
        Users user = usersService.findById(id); //crear objeto del usuario creado
        if (user == null) {
            return ResponseEntity.notFound().build(); //si  no se encuentra el usuario devuelve mensaje
        }

        usersService.deleteById(id); //borrar usuario por su id

        return ResponseEntity.ok("Deleted user id - " + id);
    }

// devolver usuario por su id
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> findUserById(@PathVariable Long id) { //pasar id
        Users user = usersService.findById(id); //buscar por id
        if (user == null) {
            return ResponseEntity.notFound().build(); //mandar mensaje si no existe
        }
        return ResponseEntity.ok(user); //retornar mensaje y usuario
    }

//actualizar usuario pr su id
    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) { //pasar id y nuevos datos usuario
        Users existingUser = usersService.findById(id); //buscar pod id
        if (existingUser == null) {
            return ResponseEntity.notFound().build(); //si no existe mandar error
        }
        
        existingUser.setUsername(updatedUser.getUsername()); //cambiar valor
        existingUser.setBirthday(updatedUser.getBirthday()); //cambiar valor
        existingUser.setMail(updatedUser.getMail());         //cambiar valor
        existingUser.setPassword(updatedUser.getPassword()); //cambiar valor
        existingUser.setProfilePhoto(updatedUser.getProfilePhoto()); //cambiar valor

        usersService.save(existingUser); //guardar usuario
        
        return ResponseEntity.ok(existingUser); //retornar mensaje y usuario nuevo
    }

//actualizar biographya del usuario
    @PutMapping("/users/{id}/biography")
    public ResponseEntity<Users> updateBiography(@PathVariable Long id, @RequestBody Users updatedUser) { //pasar id y usuario con biografia nueva
        System.out.println("Received request to update biography for user id: " + id);
        Users existingUser = usersService.findById(id); //buscar usuario por su id
        if (existingUser == null) {
            return ResponseEntity.notFound().build(); //mandar mensaje de error
        }
        
        existingUser.setBiography(updatedUser.getBiography()); //actualizar la biografia

        usersService.save(existingUser); //actualizar el usuario
        
        return ResponseEntity.ok(existingUser); //retornar mensaje y usuario nuevo
    }

//CATEGORIAS!!--------------------------------------------------------------------------------------

// metodo para retornar Categoria
@GetMapping("/categories") //GetMapping devuelve una lista de
public List<Categories> findAllCategories() {
    return categoriesService.findAll(); //metodo para retornar
}

// guardar nueva categoria
@PostMapping("/categories")
@ResponseStatus(HttpStatus.CREATED)
public Categories createCategory(@RequestBody Categories newCategory) { //pasar nueva categoria
    return categoriesService.save(newCategory); //metodo para guardar una nueva categoria
}

// borrar categoria
@DeleteMapping("/categories/{id}")
public ResponseEntity<String> deleteCategory(@PathVariable Long id) { //pasar id
    Categories category = categoriesService.findById(id); //crear objeto de la categoria creada
    if (category == null) {
        return ResponseEntity.notFound().build(); //si  no se encuentra la categoria, devuelve mensaje
    }

    categoriesService.deleteById(id); //borrar categoria por su id

    return ResponseEntity.ok("Deleted category id - " + id);
}

// devolver categoria por su id
@GetMapping("/categories/{id}")
public ResponseEntity<Categories> findCategoryById(@PathVariable Long id) { //pasar id
    Categories category = categoriesService.findById(id); //buscar por id
    if (category == null) {
        return ResponseEntity.notFound().build(); //mandar mensaje si no existe
    }
    return ResponseEntity.ok(category); //retornar mensaje y categoria
}

//actualizar categoria pr su id
@PutMapping("/categories/{id}")
public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestBody Categories updatedCategory) { //pasar id y nuevos datos categoria
    Categories existingCategory = categoriesService.findById(id); //buscar pod id
    if (existingCategory == null) {
        return ResponseEntity.notFound().build(); //si no existe mandar error
    }
    
    existingCategory.setId(updatedCategory.getId()); //cambiar valor
    existingCategory.setName(updatedCategory.getName()); //cambiar valor
    existingCategory.setIcon(updatedCategory.getIcon());         //cambiar valor

    categoriesService.save(existingCategory); //guardar usuario
    
    return ResponseEntity.ok(existingCategory); //retornar mensaje y usuario nuevo
}

//OBJETIVOS!!--------------------------------------------------------------------------------------
// metodo para retornar objetivos
@GetMapping("/achievements/{categoryid}") //GetMapping devuelve una lista de
public List<Achievements> getAchievementsByCategory(@PathVariable Long idCategory) { //buscar por categoria
    return achievementsService.findByCategoryId(idCategory); //metodo para retornar la lista
}


@GetMapping("/category/{categoryid}")
public ResponseEntity<List<Achievements>> findByCategoryId(@PathVariable Long categoryid) {
    List<Achievements> achievements = achievementsService.findByCategoryId(categoryid);
    if (achievements.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(achievements);
}

// guardar nuevo objetivo
@PostMapping("/achievements")
@ResponseStatus(HttpStatus.CREATED)
public Achievements createAchievement(@RequestBody Achievements newAchievement) { //pasar nuevo objetivo
    return achievementsService.save(newAchievement); //metodo para guardar un nuevo objetivo
}

// borrar objetivo
@DeleteMapping("/achievements/{id}")
public ResponseEntity<String> deleteAchievement(@PathVariable Long id) { //pasar id
    Achievements achievement = achievementsService.findById(id); //crear objeto de el objeto creado
    if (achievement == null) {
        return ResponseEntity.notFound().build(); //si  no se encuentra el objetivo, devuelve mensaje
    }
    achievementsService.deleteById(id); //borrar objetivo por su id
    return ResponseEntity.ok("Deleted Achievement id - " + id);
}

// devolver objetivo por su id
@GetMapping("/achievements/{id}")
public ResponseEntity<Achievements> findAchivementById(@PathVariable Long id) { //pasar id
    Achievements achivement = achievementsService.findById(id); //buscar por id
    if (achivement == null) {
        return ResponseEntity.notFound().build(); //mandar mensaje si no existe
    }
    return ResponseEntity.ok(achivement); //retornar mensaje y categoria
}

//actualizar objetivo pr su id
@PutMapping("/achievements/{id}")
public ResponseEntity<Achievements> updateAchivement(@PathVariable Long id, @RequestBody Achievements updatedAchivement) { //pasar id y nuevos datos objetivo
    Achievements existingAchivement = achievementsService.findById(id); //buscar pod id
    if (existingAchivement == null) {
        return ResponseEntity.notFound().build(); //si no existe mandar error
    }
    
    existingAchivement.setId(updatedAchivement.getId()); //cambiar valor
    existingAchivement.setIdCategory(updatedAchivement.getIdCategory()); //cambiar valor
    existingAchivement.setDescription(updatedAchivement.getDescription()); //cambiar valor
    existingAchivement.setTitle(updatedAchivement.getTitle()); //cambiar valor

    achievementsService.save(existingAchivement); //guardar objetivo
    
    return ResponseEntity.ok(existingAchivement); //retornar mensaje y objetivo nuevo
}

}