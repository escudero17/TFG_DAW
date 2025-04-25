package geomedicos.modelo.service;

import java.util.List;

import geomedicos.modelo.entities.Medico;

public interface MedicoService {
	
	Medico buscarPorColegiado(String colegiado);
	List<Medico> buscarPorEspecialidad(int idEspecialidad);
	Medico buscarPorCorreo(String correo);
	Medico buscarPorIdUsuario(int idUsuario);
	

}
