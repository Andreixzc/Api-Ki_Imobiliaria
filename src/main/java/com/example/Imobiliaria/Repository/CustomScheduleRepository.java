package com.example.Imobiliaria.Repository;

import com.example.Imobiliaria.Model.Schedule;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CustomScheduleRepository {
    private final EntityManager em;

    public CustomScheduleRepository(EntityManager em){
        this.em = em;
    }
   public List<Schedule>countOcorrency(String hour,String date){
        String query = "SELECT count(*) from schedules_users_properties WHERE hour = ? AND date = ?";
   }
}
