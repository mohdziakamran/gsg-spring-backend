package com.getseatgo.gsgspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getseatgo.gsgspring.model.entitymodel.UserInfo;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    Boolean existsByUsername(String username);
    UserInfo findByUsername(String username);
    Boolean existsByEmail(String email);


}
