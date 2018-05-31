package vol.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("legal_person")
public class ClientPhysique extends Client {

	@Column(name = "first_name", length = 100)
	private String prenom;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Civilite titre;

	public ClientPhysique() {
		super();
	}

	public ClientPhysique(String prenom, Civilite titre, String nom, String numeroTel, String numeroFax, String email) {
		super(nom, numeroTel,numeroFax,email);		
		this.prenom = prenom;
		this.titre = titre;
	}
	
	

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Civilite getTitre() {
		return titre;
	}

	public void setTitre(Civilite titre) {
		this.titre = titre;
	}
	
	public Passager toPassager() {
		Passager passager = new Passager(this.getNom(), this.getPrenom(), null);
		return passager;
	}

}
