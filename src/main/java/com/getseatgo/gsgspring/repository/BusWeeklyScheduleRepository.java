package com.getseatgo.gsgspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getseatgo.gsgspring.model.entitymodel.BusWeeklySchedule;

@Repository
public interface BusWeeklyScheduleRepository extends JpaRepository<BusWeeklySchedule,Long> {
	
	List<BusWeeklySchedule> findAllByDay(String day);
}
