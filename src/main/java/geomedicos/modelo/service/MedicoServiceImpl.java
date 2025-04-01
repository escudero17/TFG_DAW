package geomedicos.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.repository.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService{
	@Autowired
	private MedicoRepository mrepo;

	@Override
	public Medico buscarPorColegiado(String colegiado) {
		// TODO Auto-generated method stub
		return mrepo.findById(colegiado).orElse(null);
	}

}
