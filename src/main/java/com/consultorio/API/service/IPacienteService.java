package com.consultorio.API.service;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    Paciente gurdar(Paciente paciente);
    List<Paciente> listarTodos();
    Paciente buscarPorId(Long id);
    void eliminarPorId(Long id);
}
