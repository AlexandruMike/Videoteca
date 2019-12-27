package daointerface;

import java.util.List;
import model.Film;


public interface FilmDaoInterface extends ConnectionInterface {
	
	public boolean create(Film a);
	public void delete(Film a);
	public void update(Film a);
	public List<Film> readAll();
	public Film readFromTitolo(Film a);
	
}
