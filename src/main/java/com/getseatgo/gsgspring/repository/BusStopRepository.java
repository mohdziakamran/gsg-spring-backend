package com.getseatgo.gsgspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getseatgo.gsgspring.model.entitymodel.BusStop;

@Repository
public interface BusStopRepository extends JpaRepository<BusStop,Long> {
	
	BusStop findByBusStopName(String busStopName);

}
