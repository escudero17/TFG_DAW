package geomedicos.modelo.service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import geomedicos.modelo.entities.Especialidad;
import geomedicos.modelo.repository.EspecialidadRepository;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
	
	@Autowired
	private EspecialidadRepository erepo;

	@Override
	public List<Especialidad> findAll() {
		// TODO Auto-generated method stub
		return erepo.findAll();
	}

	@Override
	public Especialidad findById(Integer claveId) {
		// TODO Auto-generated method stub
		return erepo.findById(claveId).orElse(null);
	}

	@Override
	public Especialidad insertOne(Especialidad entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOne(Especialidad entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(Integer claveId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Especialidad> findByNombre(String cadena) {
		// TODO Auto-generated method stub
		return erepo.findByNombreContainingOrderByNombre(cadena);
	}

	@Override
	public Especialidad findById(int id) {
    	return erepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Especialidad no encontrada con id: " + id));
}
}
