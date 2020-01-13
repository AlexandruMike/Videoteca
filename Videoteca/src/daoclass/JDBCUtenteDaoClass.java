package daoclass;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import daointerface.UtenteDaoInterface;

import model.Utente;

public class JDBCUtenteDaoClass implements UtenteDaoInterface {
	
	//Singleton//
	private static JDBCUtenteDaoClass  instance = null;
	
	
	
	
	private JDBCUtenteDaoClass() {
		// TODO Auto-generated constructor stub
	}
	
	
	public synchronized static JDBCUtenteDaoClass getInstance() {
		if(instance==null) {
			instance = new JDBCUtenteDaoClass();
		}
		return instance;
	}
	
	//Fine Singleton//

	@Override
	public boolean create(Utente u) {
		// TODO Auto-generated method stub
		try {
			EntityManager manager = getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(u);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Utente u) {
		// TODO Auto-generated method stub
		try {
			EntityManager manager = getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Utente c=manager.find(Utente.class, u.getId());
			manager.remove(c);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}




	@Override
	public List<Utente> readAll() {
		// TODO Auto-generated method stub
		EntityManager manager = getEntityManager();
		return manager.createNamedQuery("Utente.findAll").getResultList();
	}





	@Override
	public void update(Utente u) {
		// TODO Auto-generated method stub
		try {
			EntityManager manager = getEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(u);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Utente read(String email ,String password) {
		// TODO Auto-generated method stub
		Utente c = null;
		try {
			EntityManager manager = getEntityManager();
			String query = "SELECT u FROM Utente u WHERE u.email =:email AND u.password = :password";
			Query q = manager.createQuery(query);
			q.setParameter("email", email);
			q.setParameter("password", password);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			c = (Utente) q.getSingleResult();
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
		
	}


}
