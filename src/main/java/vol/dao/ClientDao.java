package vol.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vol.model.Client;

public interface ClientDao extends JpaRepository<Client, Long> {

	Client findByNom(String lastName);
	
	@Query("select c from ClientPhysique c where c.prenom = :firstname" )
	List<Client> findByPrenom(@Param("firstname") String firstName);

}
