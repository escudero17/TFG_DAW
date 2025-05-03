package geomedicos.modelo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import geomedicos.modelo.entities.HorariosMedico;

public interface HorariosMedicoRepository extends JpaRepository<HorariosMedico, Integer>{
	
	public List<HorariosMedico> findByFechaCitaGreaterThan(LocalDate fechaInicio);

}
