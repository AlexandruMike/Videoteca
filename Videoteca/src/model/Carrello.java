package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	private Utente cliente;
	private List<Film> carrello = new ArrayList<Film>();
	
	
	public Carrello(Utente cliente) {
		this.cliente=cliente;
	}
	public Carrello(Utente cliente, List<Film> carrello) {
		this.cliente=cliente;
		this.carrello=carrello;
	}
	public List<Film> getFilmCarrello() {
		return carrello;
	}

	public void setListaFilmCarrello(List<Film> carrello) {
		this.carrello = carrello;
	}
	public void addFilm(Film film) {
		carrello.add(film);
		System.out.println("film inserito nel carrello"+carrello);
		
	}
	public void removeFilm(Film film,Utente c) {
		carrello.remove(indexFilm(film));
		Carrello nuovo = new Carrello(c,carrello);
		c.setCarrello(nuovo);
	}
	
	private int indexFilm(Film film) {
	    for (int i = 0; i < carrello.size(); i++) {
	        if (carrello.get(i).getId() == film.getId())
	            return i;
	    }
	    return -1;
	}
	
	@Override
	public String toString() {
		return "Carrello [cliente=" + cliente + ", carrello=" + carrello + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrello other = (Carrello) obj;
		if (carrello == null) {
			if (other.carrello != null)
				return false;
		} else if (!carrello.equals(other.carrello))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}

	

	
	
}
