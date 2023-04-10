package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            currentSession.beginTransaction();

//            1. Create
//            Person person = new Person("Tom", 21);
//            Person person1 = new Person("John", 42);
//            Person person2 = new Person("Jack", 19);
//
//            currentSession.save(person);
//            currentSession.save(person1);
//            currentSession.save(person2);


//            2. Update
//            Person person = currentSession.get(Person.class, 2);
//            person.setName("New name");
//            currentSession.save(person);

//            3. Delete
//            Person person = currentSession.get(Person.class, 2);
//            currentSession.delete(person);

            Person person = new Person("New name", 44);
            currentSession.save(person);

            currentSession.getTransaction().commit();

            System.out.println(person.getId());

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sessionFactory.close();
        }
    }
}
