/*
 * Created on Jul 22, 2004
 *
 * HibernateUtil - Utility class used to retrieve Hibernate Session object from singleton SessionFactory
 */
package com.reloy.util;

import net.sf.hibernate.*;
import net.sf.hibernate.cfg.*;
//import net.sf.hibernate.tool.hbm2ddl.SchemaExport;
import net.sf.hibernate.tool.hbm2ddl.SchemaUpdate;

public class HibernateUtil {

	
    private static final SessionFactory sessionFactory;

    static {
        try {

     // Create the SessionFactory & configure
           
            Configuration cfg = new Configuration();
            java.net.URL propsURL = HibernateUtil.class.getResource("/com/reloy/util/hibernate.cfg.xml");

        	System.out.println(propsURL);
            cfg.configure(propsURL);

            sessionFactory = cfg.buildSessionFactory();

     // Update (or create) the database according to the schema defined in hibernate.cfg.xml
      	    new SchemaUpdate(cfg).execute(true, true);

     // Creates new db schema according to schema defined in hibernate.cfg.xml (DROPPING any existing tables)
    	//	new SchemaExport(cfg).create(false, true);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Configuration problem: " + ex.getMessage());
        }
    }

    public static final ThreadLocal session = new ThreadLocal();

    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        // Open a new Session, if this Thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null)
            s.close();
    }
}
