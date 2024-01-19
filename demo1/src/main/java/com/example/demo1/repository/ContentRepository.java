package com.example.demo1.repository;

import com.example.demo1.model.Content;
import com.example.demo1.model.User;
import com.example.demo1.utils.SessionFactoryUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ContentRepository {
    private static SessionFactory sessionFactory = SessionFactoryUtils.getSessionFactory();

    public List<Content> getAllContents(){
        Session session = null;
        List<Content> contents = null;
        try {
            session = sessionFactory.openSession();
            contents = session.createQuery("FROM Content ", Content.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return contents;
    }

    public void addContent(Content content){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(content);
            session.getTransaction().commit();
            System.out.println("Add content successful");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Content> getContentByUserId(Long id){
        Session session = null;
        List<Content> contents = null;
        try {
            session = sessionFactory.openSession();
            User user = session.get(User.class, id);
            contents = session.createQuery("FROM Content WHERE user = :user", Content.class).setParameter("user", user).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }return contents;
    }

    public Content getContentById(Long id){
        Session session = null;
        Content content = null;
        try {
            session = sessionFactory.openSession();
            content = session.get(Content.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }return content;
        }
    }

    public void updateContent(Content content){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();;
            Content updateContent = session.get(Content.class, content.getId());
            updateContent.setTitle(content.getTitle());
            updateContent.setBrief(content.getBrief());
            updateContent.setContent(content.getContent());
            session.merge(updateContent);
            session.getTransaction().commit();
            System.out.println("Update content successful");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteContent(Long id){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Content content = session.get(Content.class, id);
            session.remove(content);
            session.getTransaction().commit();
            System.out.println("Delete content successful");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }
    }


}
