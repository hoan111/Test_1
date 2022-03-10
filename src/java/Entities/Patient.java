/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author hoan
 */
public class Patient {
    private String patientId;
    private String patientName;
    private String PhoneNumber;
    private String birthday;
    private String genderId;
    private String provinceName;
    private String wardName;
    private String districtName;
    private String identification;
    private String NationName;

    public Patient(String patientId, String patientName, String PhoneNumber, String birthday, String genderId, String provinceName, String wardName, String districtName, String identification, String NationName) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.PhoneNumber = PhoneNumber;
        this.birthday = birthday;
        this.genderId = genderId;
        this.provinceName = provinceName;
        this.wardName = wardName;
        this.districtName = districtName;
        this.identification = identification;
        this.NationName = NationName;
    }
    
    

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getNationName() {
        return NationName;
    }

    public void setNationName(String NationName) {
        this.NationName = NationName;
    }
}
