package com.medplus.service.users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Entity: Map DB table & Class

@Entity
@Table(name="doctor")
public class DoctorEntity {

    @Id
    @Column(name="dc_id")
    private String dcID;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_id")
    private String emailID;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="org_id")
    private String orgID;

    public String getDcID() {
        return dcID;
    }

    public void setDcID(String dcID) {
        this.dcID = dcID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

}
