package com.example.Imobiliaria.Controller;

import com.example.Imobiliaria.Model.Schedule;
import com.example.Imobiliaria.Repository.ScheduleRepository;
import com.example.Imobiliaria.Service.CrudService;
import com.example.Imobiliaria.Service.UserPropertiesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
@RestController
@RequestMapping("schedule")
public class ScheduleController extends CrudController <Schedule,UUID>  {
    final static LocalTime lt1 = LocalTime.of(8, 0);
    final static LocalTime lt2 = LocalTime.of(18, 0);
    final static String day1 = "SATURDAY";
    final static String day2 = "SUNDAY";
    @Autowired
    private UserPropertiesService userPropertiesService;

    private ScheduleRepository scheduleRepository;

    @Override
    protected CrudService<Schedule, UUID> getService() {
        return userPropertiesService;
    }
    @Override
    @PostMapping()
    public ResponseEntity<Schedule> cadastrar(@RequestBody @Valid Schedule entity){
        if (validateScheduleDay(entity.getDate()) && validateScheduleHour(entity.getHour())){
        return new ResponseEntity<Schedule>(getService().create(entity),HttpStatus.OK);
    }
        return null;
    }
    public boolean validateScheduleHour(LocalTime localTime){
        if (localTime.compareTo(lt1)<0 || localTime.compareTo(lt2)>0){
            return  false;
        }
        return  true;
    }
    public boolean validateScheduleDay(LocalDate localDate){
        if (localDate.getDayOfWeek().name().equals(day1) || localDate.getDayOfWeek().name().equals(day2)){
            return false;
        }
        return true;
    }
}
