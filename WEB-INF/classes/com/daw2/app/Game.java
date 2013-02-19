package com.daw2.app;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@Entity
@Table(name="games")
public class Game {
	
	@Id
	private int id;
	private String title;
	private Date release_date;
	private String publisher;
	private String system;
	private int rating;
	private int num_players;
	
	
	public Game(int id, String title, Date release_date, String publisher,
			String system, int rating, int num_players) {
		super();
		this.id = id;
		this.title = title;
		this.release_date = release_date;
		this.publisher = publisher;
		this.system = system;
		this.rating = rating;
		this.num_players = num_players;
	}
	
	public Game(String title, Date release_date, String publisher,
			String system, int rating, int num_players) {
		super();
		this.title = title;
		this.release_date = release_date;
		this.publisher = publisher;
		this.system = system;
		this.rating = rating;
		this.num_players = num_players;
	}


	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Game(int id) {
		super();
		this.id = id;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getRelease_date() {
		return release_date;
	}


	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getSystem() {
		return system;
	}


	public void setSystem(String system) {
		this.system = system;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getNum_players() {
		return num_players;
	}


	public void setNum_players(int num_players) {
		this.num_players = num_players;
	}


	public void add() {

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.save(this);
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

	public void save() {

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
		session.close();
	

	}


	
	@SuppressWarnings("unchecked")
	public static List<Game> showAll()  {

		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<Game> listGames = session.createQuery(" from Game game").list();
		session.close();
		return listGames;

	}

	public static Game getFromId(int id)  {

		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Game game=(Game) session.get(Game.class,id);
		session.close();
		return game;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


}
