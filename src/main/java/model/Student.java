package model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {

    @Id
    private int id;
    private StudentName name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentName getName() {
        return name;
    }

    public void setName(StudentName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + name + '\'' +
                '}';
    }
}
