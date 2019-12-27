package daoclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import daointerface.FilmDaoInterface;
import model.Film;

public class JDBCFilmDaoClass implements FilmDaoInterface {

	// Singleton//
	private static JDBCFilmDaoClass instance = null;

	private JDBCFilmDaoClass() {
		// TODO Auto-generated constructor stub
	}

	public synchronized static JDBCFilmDaoClass getInstance() {
		if (instance == null) {
			instance = new JDBCFilmDaoClass();
		}
		return instance;
	}

	// Fine Singleton//
	@Override
	public boolean create(Film a) {
		try {
			EntityManager manager = getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(a);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public void delete(Film a) {
		try {
			EntityManager manager = getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Film c = manager.find(Film.class, a.getId());
			manager.remove(c);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	@Override
	public void update(Film a) {
		try {
			EntityManager manager = getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(a);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Film readFromTitolo(Film a) {
		Film c = null;
		try {
			EntityManager manager = getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			c = manager.find(Film.class, a.getTitolo());
			transaction.commit();
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Film> readAll() {
		try {
			EntityManager manager = getEntityManager();
			return manager.createNamedQuery("Categoria.findAll").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
