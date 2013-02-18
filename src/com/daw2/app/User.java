package com.daw2.app;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="users")
public class User implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		public User(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}


		private int id;
		private String email;
		private String pass;
		private int type;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public int getType() {
			return type;
		}
		
		public void setType(int type) {
			this.type = type;
		}
		
		public User(String email, String pass, int type) {
			super();
			this.email = email;
			this.pass = pass;
			this.type = type;
		}
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public User(int id) {
			super();
			this.id = id;
		}
		public void add() {

			SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
			Session session = factoriaSession.openSession();
			session.beginTransaction();
			session.save(this);
			session.getTransaction().commit();
			session.close();
			
		}


		public void save() {

			SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
			Session session = factoriaSession.openSession();
			session.beginTransaction();
			session.saveOrUpdate(this);
			session.getTransaction().commit();
			session.close();
		

		}
		
		public void delete(){

			SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
			Session session = factoriaSession.openSession();
			session.beginTransaction();
			session.delete(this);
			session.getTransaction().commit();
			session.close();
			
		}
		
		// devuelve true o false en login
		@SuppressWarnings("unchecked")
		public static boolean login(String email, String pass) {
	        boolean ok = false;
	       // User logged = null;
	        String hql = "from User user where email='" + email
	                + "' and pass='" + pass + "'";
	        try {
	        	SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
				Session session = factoriaSession.openSession();
	            
				List<User> listUsers = (List<User>) session.createQuery(hql).list();
				session.close();
	            if (!listUsers.isEmpty()) {
	            	//logged = listUsers.get(0);
	                ok = true;
	            } else {
	               ok = false;
	            }
	 
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return ok;
	    }
		
		//devuelve el tipo de usuario que se ha logeado
		public static int getTypeFromEmail(String email) {
			
			String hql = "FROM User user WHERE email='"+email+"'";
			SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
			Session session = factoriaSession.openSession();
			User user = (User) session.createQuery(hql).uniqueResult();
			session.close();
			return user.getType();

			
		}
		
		@SuppressWarnings("unchecked")
		public static List<User> showAll()  {

			SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
			Session session = factoriaSession.openSession();
			List<User> listUsers = session.createQuery(" from User user").list();
			session.close();
			return listUsers;

		}
		
	
}
