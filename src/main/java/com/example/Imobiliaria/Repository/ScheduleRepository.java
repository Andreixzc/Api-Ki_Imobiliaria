package com.example.Imobiliaria.Repository;

import com.example.Imobiliaria.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {
    @Query(value = "SELECT count(*) from schedules_users_properties WHERE hour = ? AND date = ?",nativeQuery = true)
    int countConflicts(String hour,String date);

}
