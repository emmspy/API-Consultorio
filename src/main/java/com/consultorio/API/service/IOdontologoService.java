package com.consultorio.API.service;

import com.consultorio.API.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {
    Odontologo gurdar (Odontologo odontologo);
    List<Odontologo> listarTodos();
    Odontologo buscarPorId(Long id);
    void eliminarPorId(Long id);
}
