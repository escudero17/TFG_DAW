package geomedicos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import geomedicos.modelo.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, String>{
	
	public List<Medico> findByEspecialidadIdEspecialidad(int idEspecialidad);
	public Medico findByUsuarioIdUsuario(int idusuario);
	public Medico findByUsuarioCorreo(String correo);
	

   List<Medico> findByEspecialidadIdEspecialidad(int idEspecialidad);


}
