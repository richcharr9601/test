package com.example.demo1.repository;

import com.example.demo1.model.User;
import com.example.demo1.utils.SessionFactoryUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static SessionFactory sessionFactory = SessionFactoryUtils.getSessionFactory();

    public List<User> getAllUser() {
        Session session = null;
        List<User> users = null;
        try {
            session = sessionFactory.openSession();
            users = session.createQuery("FROM User", User.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

    public User getUserById(Long id) {
        Session session = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            user = session.get(User.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    public void addUser(User user) {
        Session session = null;
        Transaction ts = null;
        try {
            session = sessionFactory.openSession();
            ts = session.beginTransaction();
            session.persist(user);
            ts.commit();
            System.out.println("Add user successful");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateUser(User user) {
        Session session = null;
        Transaction ts = null;
        try {
            session = sessionFactory.openSession();
            ts = session.beginTransaction();
            User updateUser = session.get(User.class, user.getId());
            updateUser.setEmail(user.getEmail());
            updateUser.setDescription(user.getDescription());
            updateUser.setPhone(user.getPhone());
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            updateUser.setEmail(user.getEmail());
            session.merge(updateUser);
            ts.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteUser(Long userId) {
        Session session = null;
        Transaction ts = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            ts = session.beginTransaction();
            user = session.get(User.class, userId);
            session.remove(user);
            ts.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public User validateUser(String email, String password) {
        Session session = null;
        Transaction ts = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            ts = session.beginTransaction();
            user = session.createQuery("From User u where u.email = :email", User.class).setParameter("email", email).uniqueResult();
            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public User checkUser(String email) {
        Session session = null;
        Transaction ts = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            ts = session.beginTransaction();
            user = session.createQuery("From User u where u.email = :email", User.class).setParameter("email", email).uniqueResult();
            if (user != null) {
                return user;
            }
            else {
                System.out.println("User not found!");
            }
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

}
