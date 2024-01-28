package sem4.hw;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sem4.models.Course;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Course course = new Course("title", 12L);

        Course course1 = getCourseById(1L, sessionFactory);

        System.out.println(course1);

        //deleteCourseById(2L, sessionFactory);

        updateCourse(new Course("titleUpdate", 14L), 1L, sessionFactory);

//        createCourse(course, sessionFactory);


    }

    public static void createCourse(Course course, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.save(course);

            session.getTransaction().commit();
        }
    }

    public static void updateCourse(Course course, Long courseId, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Course courseFromDb = session.get(Course.class, courseId);

            courseFromDb.setTitle(course.getTitle());
            courseFromDb.setDuration(course.getDuration());

            session.save(courseFromDb);

            session.getTransaction().commit();
        }
    }

    public static Course getCourseById(Long courseId, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Course courseFromDb = session.get(Course.class, courseId);

            session.getTransaction().commit();

            return courseFromDb;
        }
    }

    public static void deleteCourseById(Long courseId, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Course courseFromDb = session.get(Course.class, courseId);

            session.delete(courseFromDb);

            session.getTransaction().commit();
        }
    }
}
