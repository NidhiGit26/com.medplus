package com.medplus.service.users.repository;

import com.medplus.service.users.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Act as an interface between DB and Application (Implementation is already handle by Spring)
@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, String> {
}
