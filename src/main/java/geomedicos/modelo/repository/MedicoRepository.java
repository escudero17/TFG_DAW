package geomedicos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import geomedicos.modelo.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, String>{

   List<Medico> findByEspecialidadIdEspecialidad(int idEspecialidad);


}
