package com.apiexample.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PastOrPresent;

import java.util.Date;

public class EmployeeDataDto {
    private long id;
    private Date date;
    private String department;
    private String team;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
