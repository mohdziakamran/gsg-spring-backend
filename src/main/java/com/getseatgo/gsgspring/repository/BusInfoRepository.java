package com.getseatgo.gsgspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getseatgo.gsgspring.model.entitymodel.BusInfo;

@Repository
public interface BusInfoRepository extends JpaRepository<BusInfo,Long> {
	
	List<BusInfo> findByBusNameAndBusNumber(String busName, String busNumber);

}
