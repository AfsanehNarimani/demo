import model.Student2;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import java.util.Map;
import java.util.Random;


public class AppQueryCache2 {

    public static void main(String[] args) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Student2.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
//        Session session = sf.openSession();
//        session.beginTransaction();
//
//        Random r = new Random();
//
//        for(int i=1; i<=50; i++){
//            Student2 s = new Student2();
//            s.setRollno(i);
//            s.setName("name "+ i);
//            s.setMark(r.nextInt(100));
//            session.save(s);
//        }
//
//        session.getTransaction().commit();
//        session.close();

        Session session1 = sf.openSession();
        session1.beginTransaction();

//        Query q = session1.createQuery("from Student2");
//        List<Student2> students = (List<Student2>) q.list();
//        for (Student2 s:students
//             ) {
//            System.out.println(s);
//        }
//        Query q = session1.createQuery("select id, name, mark from Student2");
//        List<Object[]> students = q.list();
//        for (Object[] o: students
//             ) {
//            System.out.println(o[0] + " : " + o[1] + " : " + o[2]);
//        }
//
////        Query q1 = session1.createQuery("select sum(mark) from Student2 s where s.mark>50");
//        int condition = 50;
//        Query q1 = session1.createQuery("select sum(mark) from Student2 s where s.mark> :b");
//        q1.setParameter("b",condition);
//        Object mark = (Object) q1.uniqueResult();
//        System.out.println(mark);

//        SQLQuery query = session1.createSQLQuery("select * from student2");
//        query.addEntity(Student2.class);
//        List<Student2> students = query.list();
//        for (Student2 s:students
//             ) {
//            System.out.println(s);
//        }
        //Native Queries...
        SQLQuery query = session1.createSQLQuery("select name, mark from student2");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List students = query.list();

        for (Object o: students
             ) {
            Map m = (Map)o;
            System.out.println(((Map) o).get("name") + " : " + m.get("mark"));
        }
        session1.getTransaction().commit();
        session1.close();
    }

}
