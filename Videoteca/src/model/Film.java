package model;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import daofactory.DaoFactory;

import java.util.List;

/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	@Column(name="copie")
	private int copie;
	@Column(name="durata")
	private int durata;
	@Column(name="titolo")
	private String titolo;

	

	// bi-directional many-to-one association to Noleggio
	@OneToMany(mappedBy = "film")
	private List<Noleggio> noleggios;

	// bi-directional many-to-many association to Utente
	@ManyToMany(mappedBy = "films")
	private List<Utente> utentes;

	public Film() {
	}

	public Film(String titolo, int durata, int copie) {
		// TODO Auto-generated constructor stub
		this.titolo=titolo;
		this.durata=durata;
		this.copie=copie;
	}

	public Film(String titolo) {
		// TODO Auto-generated constructor stub
		this.titolo=titolo;
	}

	public Film(int id, String titolo, int durata, int copie) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.titolo=titolo;
		this.durata=durata;
		this.copie=copie;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCopie() {
		return this.copie;
	}

	public void setCopie(int copie) {
		this.copie = copie;
	}

	public int getDurata() {
		return this.durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Noleggio> getNoleggios() {
		return this.noleggios;
	}

	public void setNoleggios(List<Noleggio> noleggios) {
		this.noleggios = noleggios;
	}

	public Noleggio addNoleggio(Noleggio noleggio) {
		getNoleggios().add(noleggio);
		noleggio.setFilm(this);

		return noleggio;
	}

	public Noleggio removeNoleggio(Noleggio noleggio) {
		getNoleggios().remove(noleggio);
		noleggio.setFilm(null);

		return noleggio;
	}

	public List<Utente> getUtentes() {
		return this.utentes;
	}

	public void setUtentes(List<Utente> utentes) {
		this.utentes = utentes;
	}

	public static List<String> getListaFilm(Utente u) {
		List<String> titoli = null;
		Noleggio n1 = new Noleggio();
		List<Noleggio> n = DaoFactory.getDAOFactory().getNoleggioDaoInterface().readAll();
		for (Noleggio noleggio : n) {
			if (noleggio.getUtente().getId() == u.getId()) {
				titoli.add(noleggio.getFilm().getTitolo());
				
			}
		}
		return titoli;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", copie=" + copie + ", durata=" + durata + ", titolo=" + titolo + "]";
	}
}
