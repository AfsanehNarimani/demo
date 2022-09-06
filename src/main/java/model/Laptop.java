package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {
    @Id
    private int lid;
    private String lname;
    @ManyToMany
    private List<StudentL> student= new ArrayList<StudentL>();

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public List<StudentL> getStudent() {
        return student;
    }

    public void setStudent(List<StudentL> student) {
        this.student = student;
    }
}
