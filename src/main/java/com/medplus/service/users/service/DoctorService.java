package com.medplus.service.users.service;

import com.medplus.service.users.dto.DoctorDTO;
import com.medplus.service.users.entity.DoctorEntity;
import com.medplus.service.users.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service: It contains Business Logic

@Service
public class DoctorService {


    private DoctorRepository repository;

    @Autowired
    DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public DoctorEntity getDoctorDetails(String id){
      Optional<DoctorEntity> doctorEntity = repository.findById(id);
      if(doctorEntity.isPresent()){
          return doctorEntity.get();
      }
      return null;
    }

    public List<DoctorEntity> getAllDoctorDetails(){
        return repository.findAll();
    }

    public void add(DoctorDTO doctorDTO){
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setDcID(doctorDTO.getDcID());
        doctorEntity.setFirstName(doctorDTO.getFirstName());
        doctorEntity.setLastName(doctorDTO.getLastName());
        doctorEntity.setEmailID(doctorDTO.getEmailID());
        doctorEntity.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctorEntity.setOrgID(doctorDTO.getOrgId());
        repository.save(doctorEntity);
    }
}
