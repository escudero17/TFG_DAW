package geomedicos.modelo.service;

import geomedicos.modelo.entities.Medico;

public interface MedicoService {
	
	Medico buscarPorColegiado(String colegiado);

}
