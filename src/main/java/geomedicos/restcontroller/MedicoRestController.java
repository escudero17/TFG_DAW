package geomedicos.restcontroller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.dto.HorarioMedicoDto;
import geomedicos.modelo.dto.MedicoDto;
import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.service.ClinicaService;
import geomedicos.modelo.service.HorariosMedicoService;
import geomedicos.modelo.service.MedicoService;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medico")
public class MedicoRestController {
	
	@Autowired
	private MedicoService mserv;
	
	@Autowired
	private ClinicaService cliserv;
	
	@Autowired
	private HorariosMedicoService horarioserv;
	
	@GetMapping("/citasProgramadas/{colegiado}/{fechaInicio}")
	public ResponseEntity<?> citasProgramadas(@PathVariable String  colegiado, @PathVariable LocalDate fechaInicio) {
	//	ResponseEntity.status(200).body(MedicoDto.convertToMedicoDto(medico));
		return ResponseEntity.status(200).body(HorarioMedicoDto.convertList(horarioserv.citasConFechamayorQue(colegiado, fechaInicio)));
		
	}
	
	@GetMapping("/especialidad/{idEspecialidad}")
	public ResponseEntity<?> uno(@PathVariable int idEspecialidad) {
	//	ResponseEntity.status(200).body(MedicoDto.convertToMedicoDto(medico));
		return ResponseEntity.status(200).body(mserv.buscarPorEspecialidad(idEspecialidad));
		
	}
	
	@GetMapping("/detalle/{colegiado}")
	public ResponseEntity<?> uno(@PathVariable String colegiado) {
		Medico medico = mserv.buscarPorColegiado(colegiado);
		
		if (medico != null)
			return ResponseEntity.status(200).body(MedicoDto.convertToMedicoDto(medico));
		else
			return ResponseEntity.status(404).body(null);
	}
	
	@PostMapping("/horario/alta")
	public ResponseEntity<?> altaHorarioMedico(@RequestBody HorarioMedicoDto horarioDto) {
		HorariosMedico horario = new HorariosMedico();
		horario.setClinica(cliserv.findById(horarioDto.getIdClinica()));
		horario.setMedico(mserv.findById(horarioDto.getColegiado()));
		horario.setFechaCita(horarioDto.getFechaCita());
		horario.setHoraInicio(horarioDto.getHoraInicio());
		
		
		if (horarioserv.insertOne(horario) != null) {
			horarioDto.setIdHorario(horario.getIdHorario());
			return ResponseEntity.status(201).body(horarioDto);
		}
			
		else
			return ResponseEntity.status(409).body(null);
	}

	
    @GetMapping("/todos")
    public List<Medico> getMedicos() {
        return mserv.findAll();
    }
	

}
