package sem4.task2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sem4.models.Student;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();


        try (Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Student student = new Student("Kirill", 20);

            session.save(student);
            System.out.println("Object save");

            Student retrievedStudent = session.get(Student.class, student.getId());
            System.out.println("Retrieved student: " + retrievedStudent.toString());

            retrievedStudent.setName("Oleg");
            retrievedStudent.setAge(21);
            session.update(retrievedStudent);
            System.out.println("Students update");

//            session.delete(retrievedStudent);
//            System.out.println("Student delete");

            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");

        } finally {
            sessionFactory.close();
        }
    }
}
