package geomedicos.restcontroller;

import geomedicos.modelo.entities.HorariosMedico;
import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.service.HorariosMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/horarios-medico")
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
    public List<Medico> getMedicosDisponibles(
            @RequestParam("especialidadId") int especialidadId,
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
    
        List<HorariosMedico> horarios = horariosMedicoService.citasConFechamayorQue(fecha);
    
        return horarios.stream()
                .map(HorariosMedico::getMedico)
                .filter(medico -> medico.getEspecialidad() != null && medico.getEspecialidad().getIdEspecialidad() == especialidadId)
                .distinct()
                .collect(Collectors.toList());
    }
    
    
}

