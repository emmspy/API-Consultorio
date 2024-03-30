package com.consultorio.API.service.implementation;

import com.consultorio.API.controller.TurnoController;
import com.consultorio.API.dto.request.TurnoRequestDTO;
import com.consultorio.API.dto.response.TurnoResponseDTO;
import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.entity.Paciente;
import com.consultorio.API.entity.Turno;
import com.consultorio.API.repository.ITurnoRepository;
import com.consultorio.API.service.ITurnoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TurnoService implements ITurnoService {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(TurnoController.class));
    private ITurnoRepository turnoRepository;
    @Override
    public TurnoResponseDTO guardar(TurnoRequestDTO turnoRequestDTO) {
        //settear de el DTO a las entidades para persistirlo a la BD
        Turno turnoEntity = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();
        //convertir formato de fecha y settearlo
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //creamos el LocalDate que vamos a tener que persistir en la BD
        LocalDate date = LocalDate.parse(turnoRequestDTO.getFecha(), formatter);

        paciente.setId(turnoRequestDTO.getPaciente_id());
        odontologo.setId(turnoRequestDTO.getOdontologo_id());

        //seteamos Paciente y Odontologo a la entidad Turno
        turnoEntity.setOdontologo(odontologo);
        turnoEntity.setPaciente(paciente);
        turnoEntity.setFechaIngreso(date);

        turnoRepository.save(turnoEntity);

        //mapear la entidad persistida a el dto response
        TurnoResponseDTO turnoResponseDTO = new TurnoResponseDTO();
        turnoResponseDTO.setId(turnoEntity.getId());
        turnoResponseDTO.setOdontologo_id(turnoEntity.getOdontologo().getId());
        turnoResponseDTO.setPaciente_id(turnoEntity.getPaciente().getId());
        turnoResponseDTO.setFecha(turnoEntity.getFechaIngreso().toString());

        return turnoResponseDTO;
    }

    @Override
    public List<TurnoRequestDTO> listarTodos() {
        return null;
    }

    @Override
    public TurnoResponseDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(TurnoRequestDTO turnoRequestDTO) {

    }
}
