package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Dao {

	SessionFactory factory = null;
	Session session = null;
	
	public Dao(){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		this.factory = cfg.buildSessionFactory();
		this.session = factory.openSession();
	}
}
