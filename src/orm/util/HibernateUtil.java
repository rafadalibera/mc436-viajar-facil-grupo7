package orm.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
        private static final SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory()
        {
                try {
                        Configuration c = new Configuration();

			c.configure("orm/hibernate.cfg.xml");

                        // Create the SessionFactory from hibernate.cfg.xml
                        return c.buildSessionFactory();
                } catch (Throwable ex) {
                        // Make sure you log the exception, as it might be swallowed
                        System.err.println("Initial SessionFactory creation failed." + ex);
                        throw new ExceptionInInitializerError(ex);
                }
        }

        public static SessionFactory getSessionFactory()
        {
                return sessionFactory;
        }
}
