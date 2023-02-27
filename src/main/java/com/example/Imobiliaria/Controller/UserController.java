package com.example.Imobiliaria.Controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    
}
