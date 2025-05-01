package geomedicos.modelo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import geomedicos.modelo.entities.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer>{
	
	List<Cita>  findByPacienteIdUsuario(int idusuario); 
	List<Cita>  findByHorariosMedicoMedicoColegiadoAndHorariosMedicoFechaCita(String colegiado, LocalDate fechaCita);
	
	 
	

}
