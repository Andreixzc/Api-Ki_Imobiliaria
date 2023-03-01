package com.example.Imobiliaria.Service;

import com.example.Imobiliaria.Controller.ScheduleController;
import com.example.Imobiliaria.Model.Schedule;
import com.example.Imobiliaria.Repository.ScheduleRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ScheduleService extends CrudService<Schedule, UUID> {
    private  final ScheduleRepository scheduleRepository;
    private  final ScheduleController scheduleController;
    static final LocalTime lt1 = LocalTime.of(8, 0);
    static final LocalTime lt2 = LocalTime.of(18, 0);
    static final String day1 = "SATURDAY";
    static final String day2 = "SUNDAY";
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

    @Override
    public Schedule create(Schedule entity) {
        int res = scheduleRepository.countConflicts(entity.getHour().toString(),entity.getDate().toString(),entity.getId());
        if (validateScheduleDay(entity.getDate()) && validateScheduleHour(entity.getHour()) && res == 0){
            scheduleController.cadastrar(entity);
        }
        return null;

    }





}
