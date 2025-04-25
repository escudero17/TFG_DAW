package geomedicos.modelo.service;

import java.util.List;

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

	@Override
	public List<Medico> buscarPorEspecialidad(int idEspecialidad) {
		// TODO Auto-generated method stub
		return mrepo.findByEspecialidadIdEspecialidad(idEspecialidad);
	}

	@Override
	public Medico buscarPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return mrepo.findByUsuarioCorreo(correo);
	}

	@Override
	public Medico buscarPorIdUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return mrepo.findByUsuarioIdUsuario(idUsuario);
	}

}
