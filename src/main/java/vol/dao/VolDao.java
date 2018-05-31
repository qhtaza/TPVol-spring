package vol.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vol.model.Vol;

public interface VolDao  extends JpaRepository<Vol, Long>{
	
	@Query("select v from Vol v where aeroportDepart.nom = :depart AND aeroportArrivee.nom = :arrivee")
	public Vol findByItineraire(@Param("depart") String aeroDepart,@Param("arrivee") String aeroArrivee);

}
