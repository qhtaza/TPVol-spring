package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="airline")
@SequenceGenerator(name="seqCompagnie", sequenceName = "airline_sequence")
public class CompagnieAerienne {
	
	@Id
	@GeneratedValue(generator="seqCompagnie")
	private Long id;
	@Version
	private int version;
	@Column(name="name", length = 100)
	private String nom;
	@OneToMany(mappedBy="compagnieAerienne")
	private List<CompagnieAerienneVol> compagnieAerienneVols = new ArrayList<>();


	public CompagnieAerienne() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	public CompagnieAerienne(String nom, List<CompagnieAerienneVol> compagnieAerienneVols) {
		this(null, nom, compagnieAerienneVols);
	}



	public CompagnieAerienne(Long id, String nom, List<CompagnieAerienneVol> compagnieAerienneVols) {
		super();
		this.id = id;
		this.nom = nom;
		this.compagnieAerienneVols = compagnieAerienneVols;
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


	public List<CompagnieAerienneVol> getCompagnieAerienneVols() {
		return compagnieAerienneVols;
	}


	public void setCompagnieAerienneVols(List<CompagnieAerienneVol> compagnieAerienneVols) {
		this.compagnieAerienneVols = compagnieAerienneVols;
	}
	
	

}
