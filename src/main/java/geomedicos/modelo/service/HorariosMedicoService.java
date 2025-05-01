package geomedicos.modelo.service;

import java.time.LocalDate;
import java.util.List;

import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.entities.Medico;

public interface HorariosMedicoService extends IntGenericoService<HorariosMedico, Integer>{
	
	List<HorariosMedico> citasConFechamayorQue(String colegiado, LocalDate fechaInicio);
	
	List<HorariosMedico>  getMedicosDisponiblesPorEspecialidadYFecha(int idEspecialidad, LocalDate fecha);

}
