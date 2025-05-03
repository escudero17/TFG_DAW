package geomedicos.modelo.service;

import java.time.LocalDate;
import java.util.List;

import geomedicos.modelo.entities.Cita;

public interface CitaService extends IntGenericoService<Cita, Integer> {
	
	List<Cita> buscarCitasPorPaciente(int idPaciente);
	List<Cita> buscarCitasPorMedicoyFecha(String colegiado, LocalDate fechaCita);
	
	
	
	
	
	
	

}
