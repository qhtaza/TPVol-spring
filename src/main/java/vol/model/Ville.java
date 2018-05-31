package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "city")
@SequenceGenerator(name = "seqVille", sequenceName = "city_sequence")
public class Ville {
	@Id
	@GeneratedValue(generator = "seqVille")
	private long id;
	@Column(name = "name")
	private String nom;
	@ManyToMany
	@JoinTable(
			name = "transit",
			joinColumns = @JoinColumn(name = "city_id"),
			inverseJoinColumns = @JoinColumn(name =
			"aeroport_id")
			)
	private List<Aeroport> aeroports = new ArrayList<>();
	@Version
	private int version;
	
	public Ville(String nom, Aeroport aeroport) {
		super();
		this.nom = nom;
		this.aeroports.add(aeroport);
	}
	
	public Ville(String nom, List<Aeroport> aeroports) {
		super();
		this.nom = nom;
		this.aeroports = aeroports;
	}
	
	public Ville(String nom) {
		super();
		this.nom = nom;
	}


	public Ville() {
		super();
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


	public List<Aeroport> getAeroports() {
		return aeroports;
	}

	public void addAeroport(Aeroport aeroport) {
		this.aeroports.add(aeroport);
	}
	
	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}
	
	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
}
