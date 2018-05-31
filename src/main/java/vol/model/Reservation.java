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
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="booking")
@SequenceGenerator(name="seqReservation", sequenceName = "booking_sequence")
public class Reservation {
	@Id
	@GeneratedValue(generator="seqReservation")
	private Long id;
	@Version
	private int version;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(name="number")
	private Integer numero;
	@ManyToOne
	@JoinColumn(name= "flight_id")
	private Vol vol;
	@ManyToOne
	@JoinColumn(name= "client_id")
	private Client client;
	@ManyToOne
	@JoinColumn(name="passenger_id")
	private Passager passager;
	
	
	public Reservation() {
		super();
	}
	
	public Reservation(Date date, Integer numero, Vol vol, Client client, Passager passager) {
		this(null, date, numero, vol, client, passager);
	}

	public Reservation(Long id, Date date, Integer numero, Vol vol, Client client, Passager passager) {
		super();
		this.id = id;
		this.date = date;
		this.numero = numero;
		this.vol = vol;
		this.client = client;
		this.passager = passager;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

}
