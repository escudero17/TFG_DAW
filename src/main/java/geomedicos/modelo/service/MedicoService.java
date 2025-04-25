package geomedicos.modelo.service;

import geomedicos.modelo.entities.Medico;
import java.util.List;
public interface MedicoService {
	
	Medico buscarPorColegiado(String colegiado);
	public List<Medico> findByEspecialidad(int idEspecialidad);
	List<Medico> findAll();


}
