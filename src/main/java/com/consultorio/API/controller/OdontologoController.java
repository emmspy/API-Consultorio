package com.consultorio.API.controller;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.service.IOdontologoService;
import com.consultorio.API.service.implementation.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private IOdontologoService odontologoService;

    @Autowired
    public OdontologoController (OdontologoService odontologoService){
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public ResponseEntity <Odontologo> buscarPorId(@PathVariable Long id){
        return null;
    }
}
