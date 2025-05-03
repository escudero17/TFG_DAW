package geomedicos.modelo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.enumerados.EstadoCita;

public interface HorariosMedicoRepository extends JpaRepository<HorariosMedico, Integer>{
	
	@Query("""
  SELECT h
    FROM HorariosMedico h
    JOIN h.medico.especialidad e
   WHERE h.fechaCita = :fecha
     AND e.idEspecialidad = :espId
""")
List<HorariosMedico> findHorariosPorFechaYEspecialidad(
    @Param("fecha") LocalDate fecha,
    @Param("espId") int especialidadId
);
	public List<HorariosMedico> findByMedicoEspecialidadIdEspecialidadAndFechaCitaGreaterThanEqualAndEstado(int idEspecialidad, LocalDate fecha, EstadoCita estado);
	
	public List<HorariosMedico> findByMedicoColegiadoAndFechaCitaAndEstado(String colegiado, LocalDate fechaCita, EstadoCita estado);

}
