package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConfig {
	private SessionFactory sf;
	public DbConfig() {
		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}
	public Session getSess() {
		Session sess = sf.openSession();
		return sess;
	}
}
