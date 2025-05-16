package com.rocky.app;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rocky.model.AnswerTable;
import com.rocky.model.QuestionTable;

public class StandardAppLaunch {

    public static void main(String[] args) {

        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        boolean flag = false;

        try {
            // Configure Hibernate
            config = new Configuration();
            config.configure(); // Reads hibernate.cfg.xml
            sessionFactory = config.buildSessionFactory();

            // Open session
            session = sessionFactory.openSession();

            // Prepare entities
//            QuestionTable q1 = new QuestionTable();
//            q1.setId(1);
//            q1.setQuestion("What is Hibernate?");

//            AnswerTable ans1 = new AnswerTable();
//            ans1.setAnswer("Hibernate is an ORM Framework.");
//            ans1.setQuestion(q1);
//
//            AnswerTable ans2 = new AnswerTable();
//            ans2.setAnswer("Hibernate is an implementation of JPA.");
//            ans2.setQuestion(q1);
//
//            List<AnswerTable> answers = new ArrayList<>();
//            answers.add(ans1);
//            answers.add(ans2);
//
//            q1.setAnswerList(answers);

            
           QuestionTable question= session.get(QuestionTable.class, 1);
           
           System.out.println(question.getQuestion());
          // question.getAnswerList().forEach((a)-> System.out.println(a));
           for(AnswerTable answers : question.getAnswerList()) {
        	   
        	   System.out.println(answers.getAnswer());
           }
            
            // Begin transaction
            transaction = session.beginTransaction();

            // Persist the question (cascades to answers)
           // session.persist(q1);

            // Commit transaction
           // transaction.commit();
            flag = true;

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!flag && transaction != null) {
                transaction.rollback();
            }
            if (session != null) {
                session.close(); // Properly close the session
            }
            if (sessionFactory != null) {
                sessionFactory.close(); // Properly close the session factory
            }
        }
    }
}
