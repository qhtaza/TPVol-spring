package vol.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import vol.dao.AeroportDao;
import vol.dao.ClientDao;
import vol.dao.CompagnieAerienneDao;
import vol.dao.CompagnieAerienneVolDao;
import vol.dao.EscaleDao;
import vol.dao.LoginDao;
import vol.dao.PassagerDao;
import vol.dao.ReservationDao;
import vol.dao.VilleDao;
import vol.dao.VolDao;
import vol.model.Client;
import vol.model.Reservation;
import vol.model.Vol;

public class TestFindUpdate {

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
		
		List<Client> mathias = clientDao.findByPrenom("mathias");
		for (Client m : mathias){
			
			System.out.println("mathias dit je m'appelle"+m.getNom()+m.getId());
		}
		
		Client leVraiMathias = clientDao.findById(1l).get();
		Vol parisLondres01 = volDao.findByItineraire("Charles de Gaulle", "Heathrow");
		Reservation reserv1 = new Reservation(new Date(), 11112, parisLondres01, leVraiMathias, leVraiMathias.toPassager());

		context.close();
	}

}
