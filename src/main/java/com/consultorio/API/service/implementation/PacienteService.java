package com.consultorio.API.service.implementation;

import com.consultorio.API.entity.Paciente;
import com.consultorio.API.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService {
    @Override
    public Paciente gurdar(Paciente paciente) {
        return null;
    }

    @Override
    public List<Paciente> listarTodos() {
        return null;
    }

    @Override
    public Paciente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void eliminarPorId(Long id) {

    }
}
