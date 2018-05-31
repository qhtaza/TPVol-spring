package vol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "stopover")
@SequenceGenerator(name = "seqEscale", sequenceName = "stopover_id")
public class Escale {
	@Id
	@GeneratedValue(generator = "seqEscale")
	private long id;
	@ManyToOne
	@JoinColumn(name = "stopoverAirport_Id", nullable = false)
	private Aeroport aeroport;
	@Column(name = "arrival_time")
	@Temporal(TemporalType.TIME)
	private Date heureArrivee;
	@Column(name = "departure_time")
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	@ManyToOne
	@JoinColumn(name="flight_ID")
	private Vol vol;
	@Version
	private int version;
	
	
	public Escale(Aeroport aeroport, Date heureArrivee, Date heureDepart, Vol vol) {
		super();
		this.aeroport = aeroport;
		this.heureArrivee = heureArrivee;
		this.heureDepart = heureDepart;
		this.vol = vol;
	}


	public Escale() {
		super();
	}


	public Aeroport getAeroport() {
		return aeroport;
	}


	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}


	public Date getHeureArrivee() {
		return heureArrivee;
	}


	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}


	public Date getHeureDepart() {
		return heureDepart;
	}


	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}


	public Vol getVol() {
		return vol;
	}


	public void setVol(Vol vol) {
		this.vol = vol;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	
}
