package com.eshwarne.docblock;

import java.io.Serializable;

public class Doctor implements Serializable {
    String name;
    String empid;
    String password;

    public Doctor() {
    }

    public Doctor(String name, String empid, String password) {
        this.name = name;
        this.empid = empid;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
