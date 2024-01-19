package com.example.demo1.utils;

import com.example.demo1.model.Content;
import com.example.demo1.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class SessionFactoryUtils {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.HBM2DDL_AUTO, "update");
                properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=testdb1;encrypt=true;trustServerCertificate=true;");
                properties.put(Environment.USER, "sa3");
                properties.put(Environment.PASS, "123456");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
                properties.put(Environment.C3P0_MIN_SIZE, 5);
                properties.put(Environment.C3P0_MAX_SIZE, 20);
                properties.put(Environment.C3P0_TIMEOUT, 1800);
                properties.put(Environment.C3P0_MAX_STATEMENTS, 50);
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Content.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                System.out.println("Hibernate Java created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }catch (Throwable ex){
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
