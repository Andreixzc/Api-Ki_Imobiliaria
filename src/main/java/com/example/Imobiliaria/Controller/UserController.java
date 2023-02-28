package com.example.Imobiliaria.Controller;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Optional> deletar(@PathVariable ID UUID){
        return new ResponseEntity<>(getService().deleteById(id),HttpStatus.OK);
    }
    //tenho que setar todos os 'ID' como UUID?
    //Tenho que dar overrride para aplicar a regra de negócio na hora de deletar o usuario
}
