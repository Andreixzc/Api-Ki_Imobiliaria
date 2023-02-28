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
        Optional<User> user = getService().findByID(id);
        if (user.isPresent()){
            user.get().setActive(false);
            getService().update(id,user.get());
            return new ResponseEntity<>("User is no longer active",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("User does not exist",HttpStatus.NOT_FOUND);

       
        
    }
    //tenho que setar todos os 'ID' como UUID?
    //Tenho que dar overrride para aplicar a regra de negócio na hora de deletar o usuario
}
