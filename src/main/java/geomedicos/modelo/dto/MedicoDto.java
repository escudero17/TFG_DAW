package geomedicos.modelo.dto;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;
import java.util.stream.Collectors;
import geomedicos.modelo.entities.Clinica;
import geomedicos.modelo.entities.Especialidad;
import geomedicos.modelo.entities.Medico;
import geomedicos.modelo.enumerados.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(of = "idUsuario")

public class MedicoDto {
	private int idUsuario;
	private String colegiado;
	private String nombre;
	private String apellidos;
	private Genero genero;
	private String email;
	private String imagen;
	private String telefono;
	private double tarifa;
	private LocalDate fechaNacimiento;
	private EspecialidadDto especialidad;
	private List<String> tratamientos;
	
	
	public static MedicoDto convertToMedicoDto(Medico medico) {
		
		ModelMapper model = new ModelMapper();
		MedicoDto mdto = model.map(medico, MedicoDto.class);
		mdto.setApellidos(medico.getUsuario().getApellidos());
		mdto.setNombre(medico.getUsuario().getNombre());
		mdto.setEmail(medico.getUsuario().getCorreo());
		mdto.setTelefono(medico.getUsuario().getTelefono());
		
		mdto.setFechaNacimiento(medico.getUsuario().getFechaNacimiento());
		mdto.setGenero(medico.getUsuario().getGenero());
		
		mdto.tratamientos = medico.getTratamientos()
					.stream().map(ele -> ele.getNombre())
					.toList();
		EspecialidadDto esp = model.map(mdto.getEspecialidad(), EspecialidadDto.class);
		mdto.setEspecialidad(esp);
		
		System.out.println(mdto);
		return mdto;
		
	}
	public static List<MedicoDto> convertList(List<Medico> medicos) {
    return medicos.stream()
                  .map(MedicoDto::convertToMedicoDto)
                  .collect(Collectors.toList());
}
	

}
