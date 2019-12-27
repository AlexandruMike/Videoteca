package daointerface;

import java.util.List;


import model.Utente;



public interface UtenteDaoInterface extends ConnectionInterface {
	
	public boolean create(Utente u);
	public boolean delete(Utente u);
	public void update(Utente u);
	public Utente read(String email);
	public List<Utente> readAll();
}
