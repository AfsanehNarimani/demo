import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;

public class AppEhCache {

    public static void main(String[] args) {
        Student student = null;

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        student = (Student) session.get(Student.class,1);
        System.out.println(student);

        student = (Student) session.get(Student.class,1);
        System.out.println(student);

        session.getTransaction().commit();
        session.close();

        Session session1 = sf.openSession();

        session1.beginTransaction();

        student = (Student) session1.get(Student.class,1);
        System.out.println(student);

        session1.getTransaction().commit();
        session1.close();
    }
}
