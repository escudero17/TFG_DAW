package geomedicos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import geomedicos.modelo.entities.Clinica;
import geomedicos.modelo.service.ClinicaService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clinicas")
public class ClinicaRestController {
	@Autowired
	private ClinicaService cserv;
	
	@GetMapping("/codigoPostal/{codigo}")
	
	public ResponseEntity<List<Clinica>> codigoPostal(@PathVariable String codigo){
		
		return ResponseEntity.ok(cserv.findByCodigoPostal(codigo));
		
	}
	
	@GetMapping("/ciudad/{ciudad}")
	
	public ResponseEntity<List<Clinica>> nombre(@PathVariable String ciudad){
		
		return ResponseEntity.ok(cserv.findByCiudad(ciudad));
		
	}
	
	@GetMapping("/{idClinica}")
	
	public ResponseEntity<Clinica> una(@PathVariable int idClinica){
		
		return ResponseEntity.ok(cserv.findById(idClinica));
		
	}

	@GetMapping("/todas")
    public ResponseEntity<List<Clinica>> todas() {
        return ResponseEntity.ok(cserv.findAll());
    }

}
