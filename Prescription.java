package com.eshwarne.docblock;

public class Prescription {
    String name;
    boolean morning;
    boolean afternoon;
    boolean evening;
    int noOfDays;

    public Prescription() {
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public Prescription(String name, boolean morning, boolean afternoon, boolean evening, int noOfDays) {
        this.name = name;
        this.morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
        this.noOfDays = noOfDays;
    }

    public Prescription(String name, boolean morning, boolean afternoon, boolean evening) {
        this.name = name;
        this.morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }

    public boolean isAfternoon() {
        return afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        this.afternoon = afternoon;
    }

    public boolean isEvening() {
        return evening;
    }

    public void setEvening(boolean evening) {
        this.evening = evening;
    }
}
