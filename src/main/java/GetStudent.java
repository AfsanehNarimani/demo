import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetStudent {
    public static void main(String[] args) {
        Student student = new Student();

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx= session.beginTransaction();
        student = (Student) session.get(Student.class, 4);
        tx.commit();

        System.out.println(student);
    }
}
