package com.stanislav.pereverziev.socialnetwork.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/29/13
 */
public class HibernateUtilTest {

    @Test
    public void testConnection() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration
                .getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
        Session session = sessionFactory.openSession();
    }
}
