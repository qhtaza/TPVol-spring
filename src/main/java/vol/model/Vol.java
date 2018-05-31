package vol.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "flight")
@SequenceGenerator(name = "seqVol", sequenceName = "flight_sequence")
public class Vol {

	@Id
	@GeneratedValue(generator = "seqVol")
	private long id;
	@Column(name = "departureDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDepart;
	@Column(name = "arrivalDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateArrivee;
	@ManyToOne
	@JoinColumn(name = "departureAirport_ID", nullable = false)
	private Aeroport aeroportDepart;
	@ManyToOne
	@JoinColumn(name = "arrivalAirport_ID", nullable = false)
	private Aeroport aeroportArrivee;
	@Column(name = "stopover_id")
	@OneToMany(mappedBy="vol")
	private List<Escale> escales = new ArrayList<Escale>();
	@OneToMany(mappedBy="vol")
	private List<Reservation> reservation;
	@OneToMany(mappedBy="vol")
	private List<CompagnieAerienneVol> compagnieAerienneVol = new ArrayList<>();
	@Transient
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	@Transient
	private SimpleDateFormat jour = new SimpleDateFormat("dd/MM/yyyy");
	@Transient
	private SimpleDateFormat heure = new SimpleDateFormat("HH:mm");
	@Version
	private int version;
	
	public Vol() {
		super();
	}

	public Vol(Date dateDepart, Date dateArrivee, Aeroport aeroportDepart, Aeroport aeroportArrivee,
			List<Escale> escales, List<Reservation> reservation, List<CompagnieAerienneVol> compagnieAerienneVol) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.escales = escales;
//		this.reservation = reservation;
//		this.compagnieAerienneVol = compagnieAerienneVol;
	}
	
	public Vol(Date dateDepart, Date dateArrivee, Aeroport aeroportDepart, Aeroport aeroportArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	
	public String getJourDepart() {
		return jour.format(this.dateDepart);
	}
	
	public void setJourDepart(Date nouveauJour) throws ParseException {
		String a = jour.format(nouveauJour)+" "+heure.format(dateDepart);
		this.dateDepart = sdf.parse(a);
	}
	
	public String getHeureDepart() {
		return heure.format(this.dateDepart);
	}
	
	public void setHeureDepart(Date nouvelleHeure) throws ParseException {
		String a = jour.format(dateDepart)+" "+heure.format(nouvelleHeure);
		this.dateDepart = sdf.parse(a);
	}
	

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public List<Escale> getEscales() {
		return escales;
	}

	public void addEscale(Escale escale) {
		this.escales.add(escale);
	}
	
	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}

//	public List<Reservation> getReservation() {
//		return reservation;
//	}
//
//	public void setReservation(List<Reservation> reservation) {
//		this.reservation = reservation;
//	}
//
//	public List<CompagnieAerienneVol> getCompagnieAerienneVol() {
//		return compagnieAerienneVol;
//	}
//
//	public void setCompagnieAerienneVol(List<CompagnieAerienneVol> compagnieAerienneVol) {
//		this.compagnieAerienneVol = compagnieAerienneVol;
//	}
	
	public String toString() {
		return dateDepart+" à "+dateArrivee+", entre "+aeroportDepart.getNom()+" et "+aeroportArrivee.getNom();
	}
	
	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
}
