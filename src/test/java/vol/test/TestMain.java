package vol.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import vol.dao.*;
import vol.model.*;


public class TestMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat jour = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat heure = new SimpleDateFormat("HH:mm");
		
		ClientDao clientDao = (ClientDao) context.getBean("clientDao");
		LoginDao loginDao = (LoginDao) context.getBean("loginDao");
		CompagnieAerienneVolDao compagnieAerienneVolDao = (CompagnieAerienneVolDao) context.getBean("compagnieAerienneVolDao");
		CompagnieAerienneDao compagnieAerienneDao = (CompagnieAerienneDao) context.getBean("compagnieAerienneDao");
		ReservationDao reservationDao = (ReservationDao) context.getBean("reservationDao");
		PassagerDao passagerDao = (PassagerDao) context.getBean("passagerDao");
		VilleDao villeDao = (VilleDao) context.getBean("villeDao");
		AeroportDao aeroportDao = (AeroportDao) context.getBean("aeroportDao");
		VolDao volDao = (VolDao) context.getBean("volDao");
		EscaleDao escaleDao = (EscaleDao) context.getBean("escaleDao");
		
		
		Client mathias = new ClientPhysique("mathias", Civilite.M,"moys","0616610107","0254856","mathias_moys@hotmail.com");
		clientDao.save(mathias);
		
		Login mmoys = new Login("mmoys", "sdjsgd", false);
		loginDao.save(mmoys);
		
		mathias.setLogin(mmoys);	
		clientDao.save(mathias);
		
		Client pierre = new ClientPhysique("pierre", Civilite.M,"grevet","02545789","02567526","pierre_grevet@hotmail.com");
		clientDao.save(pierre);
		Login mgrevet = new Login("mgrevet", "sdjfgdjhfd", false);
		loginDao.save(mgrevet);
		pierre.setLogin(mgrevet);	
		clientDao.save(pierre);
		
		Client sopra = new ClientMoral("gf25089db", Titre.LTD,"Sopra Steria","01253689","0569832","sopra_agence@sopra.fr");
		clientDao.save(sopra);
		Login ssopra = new Login("ssopra","dsfdjqsg", true);
		loginDao.save(ssopra);
		sopra.setLogin(ssopra);	
		clientDao.save(sopra);
		
		Client edf = new ClientMoral("lk31546mo", Titre.LTD,"EDF","01323596","0986325","edf_agence@edf.fr");
		clientDao.save(edf);
		Login sedf = new Login("sedf","fdvjhdfjhbd", false);
		loginDao.save(sedf);
		edf.setLogin(sedf);	
		clientDao.save(edf);

		CompagnieAerienne compAer1 = new CompagnieAerienne(null, "AirFrance", null);
		compagnieAerienneDao.save(compAer1);
		CompagnieAerienneVol compVol1 = new CompagnieAerienneVol("AF-"+String.valueOf(1000*Math.random()).substring(0, 3)+"-"+String.valueOf(1000*Math.random()).substring(0, 3), compAer1, null);
		compagnieAerienneVolDao.save(compVol1);
	
		
		Passager pass1 = new Passager("Bonblanc", "Jean", new Adresse("3 rue des potiers", "87000", "Limoges", "France"));
		passagerDao.save(pass1);
		pass1.getAdresse().setAdresse("18 rue des potiers");
		passagerDao.save(pass1);
		
		Reservation reserv1 = new Reservation(new Date(), 11456, null , null, pass1);
		reservationDao.save(reserv1);

		Ville paris = new Ville("Paris");
		Ville londres = new Ville("London");
		Ville rome = new Ville("Roma");

		Aeroport cdg = new Aeroport("Charles de Gaulle", paris);
		Aeroport orly = new Aeroport("Orly", paris);
		Aeroport heathrow = new Aeroport("Heathrow", londres);
		Aeroport fiumicino = new Aeroport("Fiumicino", rome);
		
		villeDao.save(paris);
		villeDao.save(londres);
		villeDao.save(rome);
		
		paris.addAeroport(cdg);
		londres.addAeroport(heathrow);
		rome.addAeroport(fiumicino);
		paris.addAeroport(orly);
		
		Ville noisy = new Ville("Noisy-le-Grand", cdg);
		
		aeroportDao.save(orly);
		aeroportDao.save(fiumicino);
		aeroportDao.save(cdg);
		aeroportDao.save(heathrow);

		villeDao.save(noisy);
		villeDao.save(paris);
		villeDao.save(londres);
		villeDao.save(rome);

		Date date1;
		Date date2;


		try {
			date1 = sdf.parse("04/06/2018 07:23");
			date2 = sdf.parse("04/06/2018 15:56");
			Vol volParisLondres = new Vol(date1, date2, cdg, heathrow);
			volDao.save(volParisLondres);
			System.out.println(volParisLondres.toString());
			System.out.println(volParisLondres.getHeureDepart());

			volParisLondres.setHeureDepart(heure.parse("12:55"));
			System.out.println(volParisLondres.getHeureDepart());
			volDao.save(volParisLondres);
			cdg.addVolDepartants(volParisLondres);
			heathrow.addVolArrivants(volParisLondres);

			date1 = sdf.parse("04/06/2018 15:03");
			date2 = sdf.parse("04/06/2018 22:41");
			Vol volLondresRome = new Vol(date1, date2, heathrow, fiumicino);
			volDao.save(volLondresRome);

			date1 = sdf.parse("04/06/2018 16:03");
			date2 = sdf.parse("04/06/2018 19:15");
			Escale escale1 = new Escale(cdg, date1, date2, volLondresRome);
			cdg.addEscale(escale1);
			volLondresRome.addEscale(escale1);
			escaleDao.save(escale1);
			volDao.save(volLondresRome);
			heathrow.addVolDepartants(volLondresRome);
			fiumicino.addVolArrivants(volLondresRome);
			
			aeroportDao.save(cdg);
			aeroportDao.save(heathrow);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		context.close();

		
	}

}
