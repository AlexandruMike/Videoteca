package daofactory;

import daointerface.UtenteDaoInterface;
import daointerface.FilmDaoInterface;
import daointerface.NoleggioDaoInterface;
public abstract class DaoFactory {

	/*public static final int CLOUDSCAPE = 1;
	public static final int ORACLE = 2;
	public static final int SYBASE = 3;*/ //Scelgo il Db

	public abstract FilmDaoInterface getFilmDaoInterface();

	public abstract UtenteDaoInterface getUtenteDaoInterface();
	
	public abstract NoleggioDaoInterface getNoleggioDaoInterface();
	
	public static DaoFactory getDAOFactory(/*int whichFactory*/) {
		/*switch (whichFactory) {
	      case CLOUDSCAPE: 
	          return new CloudscapeDAOFactory();
	      case ORACLE    : 
	          return new OracleDAOFactory();      
	      case SYBASE    : 
	          return new SybaseDAOFactory();
	      ...
	      default           : 
	          return null;
	    }*/
		return new JDBCDaoFactory();
	}

}
