package com.consultorio.API.controller;

import com.consultorio.API.entity.Turno;
import com.consultorio.API.service.IOdontologoService;
import com.consultorio.API.service.IPacienteService;
import com.consultorio.API.service.ITurnoService;
import com.consultorio.API.service.implementation.OdontologoService;
import com.consultorio.API.service.implementation.PacienteService;
import com.consultorio.API.service.implementation.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private ITurnoService turnoService;
    private IOdontologoService odontologoService;
    private IPacienteService pacienteService;

    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService){
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }


    //endpoint para guardar un turno
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno){
        ResponseEntity<Turno> response;

        //verificar que exista el paciente

    }
}
