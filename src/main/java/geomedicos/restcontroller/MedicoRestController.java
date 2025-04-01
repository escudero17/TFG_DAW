package geomedicos.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.dto.MedicoDto;
import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.service.MedicoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/medico")
public class MedicoRestController {
	
	@Autowired
	private MedicoService mserv;
	
	@GetMapping("/detalle/{colegiado}")
	public ResponseEntity<?> uno(@PathVariable String colegiado) {
		Medico medico = mserv.buscarPorColegiado(colegiado);
		
		if (medico != null)
			return ResponseEntity.status(200).body(MedicoDto.convertToMedicoDto(medico));
		else
			return ResponseEntity.status(404).body(null);
	}
	
	
	
	

}
