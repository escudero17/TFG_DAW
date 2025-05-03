package geomedicos.modelo.service;

import java.time.LocalDate;
import java.util.List;

import geomedicos.modelo.entities.HorariosMedico;

public interface HorariosMedicoService extends IntGenericoService<HorariosMedico, Integer>{
	

	List<HorariosMedico> medicosDisponibles(int espId, LocalDate fecha);
	
	List<HorariosMedico>  getMedicosDisponiblesPorEspecialidadYFecha(int idEspecialidad, LocalDate fecha);

}
