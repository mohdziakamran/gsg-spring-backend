package com.getseatgo.gsgspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getseatgo.gsgspring.model.entitymodel.PassengerInfo;

@Repository
public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {

}
