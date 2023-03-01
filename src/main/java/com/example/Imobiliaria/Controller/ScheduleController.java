package com.example.Imobiliaria.Controller;

import com.example.Imobiliaria.Model.Schedule;
import com.example.Imobiliaria.Service.CrudService;
import com.example.Imobiliaria.Service.UserPropertiesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
@RestController
@RequestMapping("schedule")
public class ScheduleController extends CrudController <Schedule,UUID>  {
    @Autowired
    private UserPropertiesService userPropertiesService;
    @Override
    protected CrudService<Schedule, UUID> getService() {
        return userPropertiesService;
    }
    @Override
    public ResponseEntity<Schedule> cadastrar(@RequestBody @Valid Schedule entity){
        return new ResponseEntity<>(getService().create(entity),HttpStatus.CREATED);
    }

}
