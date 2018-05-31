package vol.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "title", discriminatorType = DiscriminatorType.STRING)
public abstract class Client {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name="last_name",length =100)
	private String nom;
	@Column(name="telephone_number",length =100)
	private String numeroTel;
	@Column(name="fax_number",length =100)
	private String numeroFax;
	@Column(name="email",length =100)
	private String email;
	@OneToOne
	@JoinColumn(name = "login_ID")
	private Login login;
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations = new ArrayList<>();
	
	public Client() {
		super();
	}

	public Client(String nom, String numeroTel, String numeroFax, String email) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}





	public Passager toPassager() {
		return null;
	}
		
	
}


