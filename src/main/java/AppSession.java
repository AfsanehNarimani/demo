import model.Student;
import model.StudentName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppSession {
    public static void main(String[] args) {

        StudentName sn = new StudentName();
        sn.setFname("fname");
        sn.setLname("lname");
        sn.setMname("mname");

        Student student = new Student();
        student.setId(3);
        student.setName(sn);

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx= session.beginTransaction();
        session.save(student);
        tx.commit();

        System.out.println(student);
    }

}
