package daofactory;

import daoclass.JDBCFilmDaoClass;
import daoclass.JDBCNoleggioDaoClass;
import daoclass.JDBCUtenteDaoClass;
import daointerface.FilmDaoInterface;
import daointerface.NoleggioDaoInterface;
import daointerface.UtenteDaoInterface;

public class JDBCDaoFactory extends DaoFactory {

	@Override
	public FilmDaoInterface getFilmDaoInterface() {
		// TODO Auto-generated method stub
		return JDBCFilmDaoClass.getInstance();
	}

	@Override
	public UtenteDaoInterface getUtenteDaoInterface() {
		// TODO Auto-generated method stub
		return JDBCUtenteDaoClass.getInstance();
	}
	@Override
	public NoleggioDaoInterface getNoleggioDaoInterface() {
		// TODO Auto-generated method stub
		return JDBCNoleggioDaoClass.getInstance();
	}




}
