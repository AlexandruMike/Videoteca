package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private int id;

	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "ruolo")
	private int ruolo;

	//bi-directional many-to-one association to Noleggio
	@OneToMany(mappedBy="utente")
	private List<Noleggio> noleggios;

	//bi-directional many-to-many association to Film
	@ManyToMany
	@JoinTable(
		name="noleggio"
		, joinColumns={
			@JoinColumn(name="id_utente")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_film")
			}
		)
	private List<Film> films;
	
	@Transient
	private Carrello carrello;
	
	public Utente() {}
	
	public Utente(String email, String password, int ruolo) {
		super();
		this.email=email;
		this.password=password;
		this.ruolo=ruolo;
	}

	public Utente(Utente u) {
		// TODO Auto-generated constructor stub
		this.email=u.getEmail();
		this.password=u.getPassword();
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}

	public List<Noleggio> getNoleggios() {
		return this.noleggios;
	}

	public void setNoleggios(List<Noleggio> noleggios) {
		this.noleggios = noleggios;
	}

	public Noleggio addNoleggio(Noleggio noleggio) {
		getNoleggios().add(noleggio);
		noleggio.setUtente(this);

		return noleggio;
	}

	public Noleggio removeNoleggio(Noleggio noleggio) {
		getNoleggios().remove(noleggio);
		noleggio.setUtente(null);

		return noleggio;
	}

	public List<Film> getFilms() {
		return this.films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", email=" + email + ", password=" + password + ", ruolo=" + ruolo + ", noleggios="
				+ noleggios + ", films=" + films + "]";
	}
	
	public Carrello getCarrello() {
		return carrello;
	}
	
	public void setCarrello(Carrello carrello) {
		this.carrello=carrello;
	}
	
	public void svuotaCarrello() {
		carrello=null;
	}

}