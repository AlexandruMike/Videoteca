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
import daointerface.NoleggioDaoInterface;
import model.Film;
import model.Noleggio;
import model.Utente;

public class JDBCNoleggioDaoClass implements NoleggioDaoInterface {

	// Singleton//
	private static JDBCNoleggioDaoClass instance = null;

	private JDBCNoleggioDaoClass() {
		// TODO Auto-generated constructor stub
	}

	public synchronized static JDBCNoleggioDaoClass getInstance() {
		if (instance == null) {
			instance = new JDBCNoleggioDaoClass();
		}
		return instance;
	}

	@Override
	public boolean create(Noleggio n) {
		// TODO Auto-generated method stub
		try {
			EntityManager manager = getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(new Noleggio(n));
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Noleggio> readAll() {
		try {
			EntityManager manager = getEntityManager();
			return manager.createNamedQuery("Noleggio.findAll").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Utente> readAllFromId(Film a) {//------------match email utente su servlet------------
		// TODO Auto-generated method stub
		List <Utente> c = null;
		try {
			EntityManager manager = getEntityManager();
			String query = "SELECT n FROM Noleggio n WHERE n.id_film =:id_film";
			Query q = manager.createQuery(query);
			q.setParameter("id_film", a.getId());
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			c = (List<Utente>) q.getResultList();
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Film> readAllFromUtente(Utente a) {//------------match nome film su servlet------------
		// TODO Auto-generated method stub
		List <Film> c = null;
		try {
			EntityManager manager = getEntityManager();
			String query = "SELECT n FROM Noleggio n WHERE n.id_utente =:id_utente";
			Query q = manager.createQuery(query);
			q.setParameter("id_utente", a.getId());
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			c = (List<Film>) q.getResultList();
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
