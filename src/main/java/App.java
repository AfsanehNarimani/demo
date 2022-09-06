import model.Student;
import model.StudentName;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        Student st = new Student();
        st.setId(3);
        StudentName sn = new StudentName();
        sn.setFname("fname");
        sn.setLname("lname");
        sn.setMname("mname");
        st.setName(sn);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(st);
        em.getTransaction().commit();
       // Student st = em.find(Student.class,1);

        System.out.println(st);

    }
}
