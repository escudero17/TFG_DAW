package geomedicos.restcontroller;

import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.service.HorariosMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("api/horarios-medico")
@CrossOrigin(origins = "http://localhost:4200")
public class HorariosRestController {

    @Autowired
    private HorariosMedicoService horariosMedicoService;



    // Obtener todos los horarios (opcional, solo para debug)
    @GetMapping("/all")
    public List<HorariosMedico> getAllHorarios() {
        return horariosMedicoService.findAll();
    }

    @GetMapping("/disponibles")
    public List<HorariosMedico> getMedicosDisponibles(@RequestParam int especialidadId,@RequestParam String fecha) {
        LocalDate f = LocalDate.parse(fecha);
         return horariosMedicoService.medicosDisponibles(especialidadId, f);
    
    }
}

