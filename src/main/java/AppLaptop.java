import model.Laptop;
import model.Student;
import model.StudentL;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppLaptop {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");

        Laptop laptop1 = new Laptop();
        laptop1.setLid(102);
        laptop1.setLname("Asus");

        StudentL s = new StudentL();
        s.setRollno(1);
        s.setName("Navin");
        s.setMark(50);
        s.getLaptop().add(laptop);
        s.getLaptop().add(laptop1);

        StudentL s1 = new StudentL();
        s1.setRollno(2);
        s1.setName("Navin2");
        s1.setMark(10);
        s1.getLaptop().add(laptop1);

        laptop.getStudent().add(s);
        laptop1.getStudent().add(s);

        laptop1.getStudent().add(s1);

        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(StudentL.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.save(laptop);
        session.save(laptop1);
        session.save(s);
        session.save(s1);

//        session.get(StudentL.class,1);
        session.getTransaction().commit();

        System.out.println(s);

    }
}
