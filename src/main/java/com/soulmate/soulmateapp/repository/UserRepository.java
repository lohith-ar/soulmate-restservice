package com.soulmate.soulmateapp.repository;

import com.soulmate.soulmateapp.domain.SoulmateUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<SoulmateUser,Integer> {
}
