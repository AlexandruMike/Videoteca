package daointerface;

import java.util.List;

import model.Film;
import model.Noleggio;
import model.Utente;

public interface NoleggioDaoInterface extends ConnectionInterface {

	
	public boolean create(Noleggio n);
	public List<Utente> readAllFromId(Film a);
	public List<Film> readAllFromUtente(Utente a);
	List<Noleggio> readAll();

}
