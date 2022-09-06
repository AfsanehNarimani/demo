import model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class AppQueryCache {
    public static void main(String[] args) {

        Student student = null;

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg =  new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();
        session.beginTransaction();
        Query q1 = session.createQuery("from Student where id =1");
        q1.setCacheable(true);
        student = (Student) q1.uniqueResult();
        System.out.println(student);
        session.getTransaction().commit();
        session.close();

        Session session1 = sf.openSession();
        session1.beginTransaction();
        Query q2 = session1.createQuery("from Student where id =1");
        q2.setCacheable(true);
        student = (Student) q2.uniqueResult();
        System.out.println(student);
        session1.getTransaction().commit();
        session1.close();

    }
}
