package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "airport")
@SequenceGenerator(name = "seqAeroport", sequenceName = "airport_sequence")
public class Aeroport {
	@Id
	@GeneratedValue(generator = "seqAeroport")
	private long id;
	@Column(name = "name")
	private String nom;
	@Version
	private int version;
	@ManyToMany(mappedBy = "aeroports")
	private List<Ville> villes = new ArrayList<Ville>();
	@OneToMany(mappedBy = "aeroportDepart")
	private List<Vol> volsDepartants = new ArrayList<Vol>();
	@OneToMany(mappedBy = "aeroportArrivee")
	private List<Vol> volsArrivants = new ArrayList<Vol>();
	@OneToMany(mappedBy = "aeroport")
	private List<Escale> escales = new ArrayList<Escale>();
	

	
	public Aeroport() {
		super();
	}



	public Aeroport(String nom, List<Ville> villes, List<Vol> volsDepartants, List<Vol> volsArrivants,
			List<Escale> escales) {
		super();
		this.nom = nom;
		this.villes = villes;
		this.volsDepartants = volsDepartants;
		this.volsArrivants = volsArrivants;
		this.escales = escales;
	}
	
	public Aeroport(String nom, List<Ville> villes) {
		super();
		this.nom = nom;
		this.villes = villes;
	}
	
	public Aeroport(String nom, Ville ville) {
		super();
		this.nom = nom;
		this.villes.add(ville);
	}

	public Aeroport(String nom) {
		super();
		this.nom = nom;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public List<Ville> getVilles() {
		return villes;
	}

	public void addVille(Ville ville) {
		this.villes.add(ville);
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}


	public List<Vol> getVolsDepartants() {
		return volsDepartants;
	}

	public void addVolDepartants(Vol vol) {
		this.volsDepartants.add(vol);
	}

	public void setVolsDepartants(List<Vol> volsDepartants) {
		this.volsDepartants = volsDepartants;
	}


	public List<Vol> getVolsArrivants() {
		return volsArrivants;
	}

	public void addVolArrivants(Vol vol) {
		this.volsArrivants.add(vol);
	}

	public void setVolsArrivants(List<Vol> volsArrivants) {
		this.volsArrivants = volsArrivants;
	}


	public List<Escale> getEscales() {
		return escales;
	}

	public void addEscale (Escale escale) {
		this.escales.add(escale);
	}

	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}
	
}
