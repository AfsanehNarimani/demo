package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StudentL {
    @Id
    private int rollno;
    private String name;
    private int mark;
    @ManyToMany(mappedBy = "student")
    private List<Laptop> laptop = new ArrayList<Laptop>();

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "StudentL{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + mark +
                ", laptop=" + laptop +
                '}';
    }
}
