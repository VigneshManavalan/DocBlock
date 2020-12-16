package com.eshwarne.docblock;

import java.io.Serializable;
import java.util.List;

public class Patient implements Serializable {
    String name;
    String id;
    String height;
    String weight;
    String sex;
    String bp;

    int age;
    String temperature;
    String passwordHash;
    String password;
    String currentSymptoms;
    List<Prescription> prescriptionList;
    List<String> earlierSymptoms;



    public Patient(String name, String id, String sex, int age, String passwordHash,String password) {
        this.password = password;
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.passwordHash = passwordHash;

    }

    public Patient(String name, String id, String sex, int age, String passwordHash,String password,String currentSymptoms) {
        this.password = password;
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.currentSymptoms = currentSymptoms;
        this.passwordHash = passwordHash;
    }


    public Patient() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentSymptoms() {
        return currentSymptoms;
    }

    public void setCurrentSymptoms(String currentSymptoms) {
        this.currentSymptoms = currentSymptoms;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    public List<String> getEarlierSymptoms() {
        return earlierSymptoms;
    }

    public void setEarlierSymptoms(List<String> earlierSymptoms) {
        this.earlierSymptoms = earlierSymptoms;
    }
}
