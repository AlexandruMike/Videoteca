package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the noleggio database table.
 * 
 */
@Entity
@NamedQuery(name="Noleggio.findAll", query="SELECT n FROM Noleggio n")
public class Noleggio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Film
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_film")
	private Film film;

	//bi-directional many-to-one association to Utente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_utente")
	private Utente utente;
	

	public Noleggio() {
	}

	public Noleggio(Film film, Utente utente) {
		this.film=film;
		this.utente=utente;
	}
	
	public Noleggio(Noleggio n) {
		// TODO Auto-generated constructor stub
		this.film=n.getFilm();
		this.utente=n.getUtente();
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Noleggio [id=" + id + ", film=" + film + ", utente=" + utente + "]";
	}
	
	
}