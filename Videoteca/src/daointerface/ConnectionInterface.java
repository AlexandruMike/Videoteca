package daointerface;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public interface ConnectionInterface {

	public default void loadDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public default EntityManager getEntityManager() {
		loadDriver();
		//
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
		//
		EntityManager entity = factory.createEntityManager();
		return entity;
	}
}
