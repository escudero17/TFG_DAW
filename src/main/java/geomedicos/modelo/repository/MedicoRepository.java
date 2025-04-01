package geomedicos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import geomedicos.modelo.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, String>{

}
