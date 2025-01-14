package com.dam2.flutter.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import java.util.Base64; 
import java.nio.file.Path; 
import com.dam2.flutter.service.AchievementsFavoritesService;
import com.dam2.flutter.entity.AchievementsFavorites;

import com.dam2.flutter.entity.Achievements;
import com.dam2.flutter.entity.Categories;
import com.dam2.flutter.entity.FriendRequests;
import com.dam2.flutter.entity.Friendships;
import com.dam2.flutter.entity.UserAchievements;
import com.dam2.flutter.entity.Users;
import com.dam2.flutter.service.CategoriesService;
import com.dam2.flutter.service.FriendRequestsService;
import com.dam2.flutter.service.FriendshipsService;
import com.dam2.flutter.service.UsersService;
import com.dam2.flutter.service.AchievementsService;
import com.dam2.flutter.service.UserAchievementsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    private AchievementsService achievementsService; //objeto de la interfaz AchievementsService "tendra los atributos de la classe Achievements desde achievementsdao..."

    //objeto para guardar los objetivos
    @Autowired //inyeccion de dependencias
    private UserAchievementsService userachievementsService; //objeto de la interfaz UserAchievementsService "tendra los atributos de la classe UserAchievements desde achievementsdao..."

    //objeto para guardar los amigos
    @Autowired
    private FriendshipsService friendshipsService;

    //objeto para guardar las solicitudes de amistad
    @Autowired
    private FriendRequestsService friendRequestsService;

    @Autowired //inyeccion de dependencias
    private AchievementsFavoritesService achievementsFavoritesService; //objeto de la interfaz UserAchievementsService "tendra los atributos de la classe UserAchievements desde achievementsdao..."


//USUARIOS!!----------------------------------------------------------------------------------------
// metodo para retornar usuarios
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


//actualizar usuario pr su id    //PARA ACTUALIZAR OTRA COSA QUE NO SEA FOTO PONGA EL CONDICIONAL AL SETPROFILEPHOTO
    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) { //pasar id y nuevos datos usuario
        Users existingUser = usersService.findById(id); //buscar pod id

        if (existingUser == null) {
            return ResponseEntity.notFound().build(); //si no existe mandar error
        }

            existingUser.setProfilephoto(updatedUser.getProfilephoto());

        // Actualizar solo los campos que no son nulos
        if (updatedUser.getUsername() != null) {
            existingUser.setUsername(updatedUser.getUsername()); // Actualizar username
        }
        if (updatedUser.getBirthday() != null) {
            existingUser.setBirthday(updatedUser.getBirthday()); // Actualizar birthday
        }
        if (updatedUser.getMail() != null) {
            existingUser.setMail(updatedUser.getMail()); // Actualizar mail
        }
        if (updatedUser.getPassword() != null) {
            existingUser.setPassword(updatedUser.getPassword()); // Actualizar password
        }
        if (updatedUser.getBiography() != null) {
            existingUser.setBiography(updatedUser.getBiography()); // Actualizar biografia
        }
        if (updatedUser.getYoutube() != null) {
            existingUser.setYoutube(updatedUser.getYoutube()); // Actualizar Youtube
        }
        if (updatedUser.getTwitterx() != null) {
            existingUser.setTwitterx(updatedUser.getTwitterx()); // Actualizar Twitterx
        }
        if (updatedUser.getFacebook() != null) {
            existingUser.setFacebook(updatedUser.getFacebook()); // Actualizar Facebook
        }
        if (updatedUser.getTwitch() != null) {
            existingUser.setTwitch(updatedUser.getTwitch()); // Actualizar Twitch
        }
        if (updatedUser.getReddit() != null) {
            existingUser.setReddit(updatedUser.getReddit()); // Actualizar Reddit
        }
        if (updatedUser.getSteam() != null) {
            existingUser.setSteam(updatedUser.getSteam()); // Actualizar Steam
        }
        if (updatedUser.getEpicgames() != null) {
            existingUser.setEpicgames(updatedUser.getEpicgames()); // Actualizar Epicgames
        }
        if (updatedUser.getNswitch() != null) {
            existingUser.setNswitch(updatedUser.getNswitch()); // Actualizar Nswitch
        }
        if (updatedUser.getPsn() != null) {
            existingUser.setPsn(updatedUser.getPsn()); // Actualizar Psn
        }
        if (updatedUser.getXbox() != null) {
            existingUser.setXbox(updatedUser.getXbox()); // Actualizar Xbox
        }

        usersService.save(existingUser); //guardar usuario
        
        return ResponseEntity.ok(existingUser); //retornar mensaje y usuario nuevo
    }



//actualizar biografía del usuario
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

    //obtener usuario por id
    @GetMapping("/users/{id}")
    public Users getUserById(@PathVariable Long id) {
        return usersService.findById(id); // Llama al servicio que busca por ID
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
    @GetMapping("/achievements/category/{categoryId}")
    public ResponseEntity<List<Achievements>> findAchievementsByCategoryId(@PathVariable Long categoryId) {
        List<Achievements> achievements = achievementsService.findByCategoryId(categoryId);
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
    public ResponseEntity<Achievements> findAchievementById(@PathVariable Long id) { //pasar id
        Achievements achievement = achievementsService.findById(id); //buscar por id
        if (achievement == null) {
            return ResponseEntity.notFound().build(); //mandar mensaje si no existe
        }
        return ResponseEntity.ok(achievement); //retornar mensaje y categoria
    }

//actualizar objetivo pr su id
    @PutMapping("/achievements/{id}")
    public ResponseEntity<Achievements> updateAchievement(@PathVariable Long id, @RequestBody Achievements updatedAchievement) { //pasar id y nuevos datos objetivo
        Achievements existingAchievement = achievementsService.findById(id); //buscar pod id
        if (existingAchievement == null) {
            return ResponseEntity.notFound().build(); //si no existe mandar error
        }
        
        existingAchievement.setId(updatedAchievement.getId()); //cambiar valor
        existingAchievement.setCategoryid(updatedAchievement.getCategoryid()); //cambiar valor
        existingAchievement.setDescription(updatedAchievement.getDescription()); //cambiar valor
        existingAchievement.setTitle(updatedAchievement.getTitle()); //cambiar valor

        achievementsService.save(existingAchievement); //guardar objetivo
        
        return ResponseEntity.ok(existingAchievement); //retornar mensaje y objetivo nuevo
    }

    @GetMapping("/Achievements")
    public List<Achievements> getAchievements() {
        return achievementsService.findAll();
    }

    //buscar objetivo que contenga un texto en titulo od escripción

    @GetMapping("/achievements/search")
    public ResponseEntity<List<Achievements>> searchAchievements(@RequestParam String query) {
        List<Achievements> achievements = achievementsService.searchAchievements(query);
        if (achievements.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content si no hay resultados
        }
        return ResponseEntity.ok(achievements); // 200 OK con la lista de logros
    }

//USERACHIEVEMENTS!!--------------------------------------------------------------------------------------
// devolver si el userachievements existe o no
    @GetMapping("/userachievements/{achievementId}/{userId}")
    public ResponseEntity<UserAchievements> findUserAchievementByBothId(@PathVariable Long achievementId, @PathVariable Long userId) {
        UserAchievements userAchievement = userachievementsService.findByBothId(achievementId, userId);
        if (userAchievement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userAchievement);
    }

    @PostMapping("/userachievement")
    public ResponseEntity<?> createUserAchievement(
            @RequestParam Long achievementId,
            @RequestParam Long userId) {
        UserAchievements newAchievement = new UserAchievements(null, achievementId, userId, 0, 0);
        userachievementsService.save(newAchievement);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/userachievement/{achievementId}/{userId}")
    public ResponseEntity<?> deleteUserAchievement(
            @PathVariable Long achievementId,
            @PathVariable Long userId) {
        UserAchievements userAchievement = userachievementsService.findByBothId(achievementId, userId);
        if (userAchievement != null) {
            userachievementsService.deleteById(userAchievement.getId());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
//
    @GetMapping("/userachievement/{userId}")
    public ResponseEntity<List<UserAchievements>> findUserAchievementsByUserId(@PathVariable Long userId) {
        // Usar el servicio para buscar los logros por userId
        List<UserAchievements> userAchievements = userachievementsService.findByUserId(userId);

        // Verificar si la lista está vacía y devolver la respuesta adecuada
        if (userAchievements.isEmpty()) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content si no hay resultados
        }
        return ResponseEntity.ok(userAchievements); // HTTP 200 OK con la lista de logros
    }
//FRIENDS!!--------------------------------------------------------------------------------------
    // Obtener todas las amistades
    @GetMapping("/friendships")
    public List<Friendships> getAllFriendships() {
        return friendshipsService.findAll();
    }

    //agregar amistad
    @PostMapping("/friendships")
    @ResponseStatus(HttpStatus.CREATED)  // Esto indica que la amistad se ha creado exitosamente
    public Friendships createFriendship(@RequestBody Friendships newFriendship) {
        return friendshipsService.saveFriendship(newFriendship); // Llama al servicio para guardar la nueva amistad
    }

    @DeleteMapping("/friendships/{friendshipId}")
    public ResponseEntity<?> deleteFriendship(@PathVariable Long friendshipId) {
        // Buscar la amistad por su ID
        Friendships friendship = friendshipsService.findById(friendshipId);
        
        // Si la amistad existe, eliminarla
        if (friendship != null) {
            friendshipsService.deleteFriendship(friendshipId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

//FRIENDSREQUESTS!!--------------------------------------------------------------------------------------
    // Obtener todas las solicitudes de amistad
    
    @GetMapping("/friendrequests")
    public List<FriendRequests> getAllFriendRequests() {
        return friendRequestsService.findAll();
    }

    //agregar amistad
    @PostMapping("/friendrequests")
    @ResponseStatus(HttpStatus.CREATED)  // Esto indica que la amistad se ha creado exitosamente
    public FriendRequests createFriendRequests(@RequestBody FriendRequests friendRequest) {
        return friendRequestsService.saveFriendRequest(friendRequest); // Llama al servicio para guardar la nueva amistad
    }

    @DeleteMapping("/friendrequests/{friendrequestId}")
    public ResponseEntity<?> deleteFriendRequest(@PathVariable Long friendrequestId) {
        // Buscar la solicitud de amistad por su ID
        FriendRequests friendRequest = friendRequestsService.findById(friendrequestId);
        
        // Si la solicitud de amistad existe, eliminarla
        if (friendRequest != null) {
            friendRequestsService.deleteFriendRequest(friendrequestId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // Devuelve 204 No Content
        }
        
        // Si la solicitud de amistad no existe, devolver error 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //FAVORITEACHIEVEMENTS!!--------------------------------------------------------------------------------------


 // Devolver la lista de favoritos de un determinado usuario
 @GetMapping("/achievementsfavorites/{userId}")
 public ResponseEntity<List<AchievementsFavorites>> findAchievementsFavoritesByUserId(@PathVariable Long userId) {
     List<AchievementsFavorites> favoriteAchievements = achievementsFavoritesService.findByUserId(userId);
     if (favoriteAchievements.isEmpty()) {
         return ResponseEntity.notFound().build(); // 404 Not Found
     }
     return ResponseEntity.ok(favoriteAchievements); // 200 OK
 }   


 @PostMapping("/achievementsfavorites")
 @ResponseStatus(HttpStatus.CREATED)
 public AchievementsFavorites addFavorite(@RequestBody AchievementsFavorites achievementsfavorites) {
    return achievementsFavoritesService.saveFavorite(achievementsfavorites);
}



@DeleteMapping("/achievementsfavorites/{userId}/{achievementId}")
public ResponseEntity<String> deleteFavorite(@PathVariable int userId, @PathVariable int achievementId) {
    AchievementsFavorites achievementFavorite = achievementsFavoritesService.findByUserIdAndAchievementId(userId, achievementId);
    if (achievementFavorite == null) {
        return ResponseEntity.notFound().build(); // Si no se encuentra, devolver 404
    }

    achievementsFavoritesService.deleteFavorite(achievementFavorite); // Lógica para eliminar
    return ResponseEntity.ok("Deleted favorite achievement for user " + userId);
}

@GetMapping("/achievementsfavorites/{userId}/{achievementId}")
public ResponseEntity<Object> findByUserIdAndAchievementId(@PathVariable int userId, @PathVariable int achievementId) {
    AchievementsFavorites achievementFavorite = achievementsFavoritesService.findByUserIdAndAchievementId(userId, achievementId);
    if (achievementFavorite == null) {
        return ResponseEntity.notFound().build(); // 404 Not Found
    }
    return ResponseEntity.ok(achievementFavorite); // 200 OK
}  
}