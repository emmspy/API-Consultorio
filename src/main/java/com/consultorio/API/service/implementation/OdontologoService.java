package com.consultorio.API.service.implementation;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IOdontologoService {
    @Override
    public Odontologo gurdar(Odontologo odontologo) {
        return null;
    }

    @Override
    public List<Odontologo> listarTodos() {
        return null;
    }

    @Override
    public Odontologo buscarPorId(Long id) {
        return null;
    }

    @Override
    public void eliminarPorId(Long id) {

    }
}
