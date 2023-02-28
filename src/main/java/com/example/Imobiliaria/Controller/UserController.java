package com.example.Imobiliaria.Controller;

import java.net.http.HttpHeaders;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Imobiliaria.Model.User;
import com.example.Imobiliaria.Service.CrudService;
import com.example.Imobiliaria.Service.UserService;
@RestController
@RequestMapping("user")
public class UserController extends CrudController<User,UUID> {
    @Autowired
    private UserService userService;
    
    @Override
    protected CrudService<User, UUID> getService() {
        return userService;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable UUID id){
        if (getService().findByID(id).isPresent()) {
            Optional<User> user = getService().findByID(id);
            user.get().setActive(false);
            return new ResponseEntity<>("Usuario não esta mais ativo",HttpStatus.OK); 
        }
        return new ResponseEntity<>("Usuário não existe",HttpStatus.NOT_FOUND);

       
        
    }
    //tenho que setar todos os 'ID' como UUID?
    //Tenho que dar overrride para aplicar a regra de negócio na hora de deletar o usuario
}
