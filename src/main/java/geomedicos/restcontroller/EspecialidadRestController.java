package geomedicos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.entities.Especialidad;
import geomedicos.modelo.service.EspecialidadService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/especialidades")
public class EspecialidadRestController {
	
	@Autowired
	private EspecialidadService eserv;
	
	@GetMapping("/todas")
	public ResponseEntity<List<Especialidad>> todas() {
		 return ResponseEntity.ok(eserv.findAll());
	}
	
	@GetMapping("/nombre/{cadena}")
	public ResponseEntity<List<Especialidad>> nombre(@PathVariable String cadena) {
		 return ResponseEntity.ok(eserv.findByNombre(cadena));
	}
	

}
