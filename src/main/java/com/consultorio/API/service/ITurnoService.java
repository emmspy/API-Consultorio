package com.consultorio.API.service;

import com.consultorio.API.dto.request.TurnoRequestDTO;
import com.consultorio.API.dto.response.TurnoResponseDTO;
import com.consultorio.API.entity.Turno;

import java.util.List;

public interface ITurnoService {
    TurnoResponseDTO guardar(TurnoRequestDTO turnoRequestDTO);
    List<TurnoRequestDTO> listarTodos();
    TurnoResponseDTO buscarPorId(Long id);
    void eliminar(Integer id);
    void actualizar(TurnoRequestDTO turnoRequestDTO);
}
