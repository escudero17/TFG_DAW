package geomedicos.restcontroller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.dto.CitaDto;
import geomedicos.modelo.entities.Cita;
import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.enumerados.EstadoCita;
import geomedicos.modelo.service.CitaService;
import geomedicos.modelo.service.HorariosMedicoService;
import geomedicos.modelo.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/paciente")
public class PacienteRestController {
	
	@Autowired
	private CitaService cserv;
	@Autowired
	private HorariosMedicoService mserv;
	@Autowired
	private UsuarioService userv;
	
	@GetMapping("/miscitas/{idUsuario}")
	public ResponseEntity<?> misCitas(@PathVariable int idUsuario){
		System.out.println("Entrando a /miscitas/" + idUsuario);
		return ResponseEntity.status(200).body(CitaDto.convertList(cserv.buscarCitasPorPaciente(idUsuario)));
	}
	
	
	@PostMapping("/miscitas/alta")
	public ResponseEntity<?> altaCita(@RequestBody CitaDto citadto) {
	
		Cita cita = new Cita();
		HorariosMedico horario = mserv.findById(citadto.getIdHorario());
		cita.setFecha(LocalDate.now());
		cita.setHorariosMedico(horario);
		cita.setPaciente(userv.findById(citadto.getIdUsuario()));
		horario.setEstado(EstadoCita.CONFIRMADA);
	
		if (cserv.insertOne(cita) != null) {
			citadto.setIdCita(cita.getIdCita());
			citadto.setIdUsuario(cita.getPaciente().getIdUsuario()); // ✅ esta línea soluciona el problema
			mserv.updateOne(horario);
			return ResponseEntity.status(201).body(citadto);
		} else {
			return ResponseEntity.status(409).body(null);
		}
	}
	
	@DeleteMapping("/miscitas/eliminar/{idCita}")
	public ResponseEntity<?> eliminarCita(@PathVariable int idCita){
		
			
			HorariosMedico horario = mserv.findById(cserv.findById(idCita).getHorariosMedico().getIdHorario());
			horario.setEstado(EstadoCita.PENDIENTE);
			
			cserv.deleteOne(idCita);
			mserv.updateOne(horario);
			return ResponseEntity.status(200).body("citaEliminada");
		
		
	}

}
