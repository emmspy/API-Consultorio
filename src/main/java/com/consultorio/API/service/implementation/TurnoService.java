package com.consultorio.API.service.implementation;

import com.consultorio.API.entity.Turno;
import com.consultorio.API.service.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Override
    public Turno guardar(Turno turno) {
        return null;
    }

    @Override
    public List<Turno> listarTodos() {
        return null;
    }

    @Override
    public Turno buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Turno turno) {

    }
}
