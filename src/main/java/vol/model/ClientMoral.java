package vol.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("legal_entity")
public class ClientMoral extends Client {

	@Column(name = "company_code", length = 100)
	private String siret;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Titre titre;
	
	
	
	public ClientMoral() {
		super();
	}
	
	



	public ClientMoral(String siret, Titre titre,String nom, String numeroTel, String numeroFax, String email) {
		super(nom, numeroTel, numeroFax, email);
		this.siret = siret;
		this.titre = titre;
	}



	public String getSiret() {
		return siret;
	}



	public void setSiret(String siret) {
		this.siret = siret;
	}



	public Titre getTitre() {
		return titre;
	}



	public void setTitre(Titre titre) {
		this.titre = titre;
	}
	
	
}
