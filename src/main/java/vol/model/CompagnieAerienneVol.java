package vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="airline_flight")
@SequenceGenerator(name="seqCompagnieVol", sequenceName = "airlineFlight_sequence")
public class CompagnieAerienneVol {
	
	@Id
	@GeneratedValue(generator = "seqCompagnieVol")
	private Long id;
	@Column(name="flight_number", length = 100, unique=true)
	private String numero;
	@ManyToOne
	@JoinColumn(name="airline_id")
	private CompagnieAerienne compagnieAerienne;
	@ManyToOne
	@JoinColumn(name="flight_id")
	private Vol vol;

	public CompagnieAerienneVol() {
		super();
	}
	
	
	
	public CompagnieAerienneVol(String numero, CompagnieAerienne compagnieAerienne, Vol vol) {
		this(null, numero, compagnieAerienne, vol);
	}



	public CompagnieAerienneVol(Long id, String numero, CompagnieAerienne compagnieAerienne, Vol vol) {
		super();
		this.id = id;
		this.numero = numero;
		this.compagnieAerienne = compagnieAerienne;
		this.vol = vol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long numero) {
		this.id = numero;
	}

	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

}
