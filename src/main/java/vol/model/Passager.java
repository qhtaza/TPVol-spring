package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="passenger")
@SequenceGenerator(name="seqPassager", sequenceName = "passenger_sequence")
public class Passager {
	@Id
	@GeneratedValue(generator="seqPassager")
	private Long id;
	@Version
	private int version;
	@Column(name="lastname", length = 100)
	private String nom;
	@Column(name="firstname", length = 100)
	private String prenom;
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy="passager")
	private List<Reservation> reservations = new ArrayList<>();
	 
	
	public Passager() {
		super();
	}

	public Passager(String nom, String prenom, Adresse adresse) {
		this(null, nom, prenom, adresse);	
	}

	public Passager(Long id, String nom, String prenom, Adresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	
}
