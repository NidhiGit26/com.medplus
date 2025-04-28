package com.medplus.service.users.controller;

import com.medplus.service.users.dto.DoctorDTO;
import com.medplus.service.users.entity.DoctorEntity;
import com.medplus.service.users.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

//Controller: API endpoints
@RestController
@Slf4j
public class DoctorController {

    /*

    CRUD
    Create - add
    Read - getById and getAll
    Update - X
    Delete - X
     */

    /*
    Start Thinking

    1. mujhe method banani padegi controller mai
    2. mjhe get mapping likhna padegi agar get request kar rahi hun
    3. Mjhe kya pass kar rahe hai.. agar kch id pass kar rahe toh use parameter mai lena padega
    4. Mjhe return kya karna  hai.. List, Sirf ek object return ya kch return nahi karna hai..

     */

    private DoctorService dcService;

    @Autowired
    DoctorController(DoctorService dcService){
        this.dcService = dcService;
    }

    @GetMapping("/doctor")
    public String get() {
        return "Admin";
    }

    @GetMapping("/doctor/{id}")
    public DoctorEntity getDoctorByID(@PathVariable String id) {
        return dcService.getDoctorDetails(id);
    }

    @GetMapping("/doctor/all")
    public List<DoctorEntity> getAllDoctorList(){
        return dcService.getAllDoctorDetails();
    }

    @PostMapping("/doctor")
    public void addDoctor(@RequestBody DoctorDTO doctorDTO){
        dcService.add(doctorDTO);
        log.info(doctorDTO.toString());
    }
}
