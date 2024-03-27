package com.consultorio.API.controller;

import com.consultorio.API.entity.Turno;
import com.consultorio.API.service.IOdontologoService;
import com.consultorio.API.service.IPacienteService;
import com.consultorio.API.service.ITurnoService;
import com.consultorio.API.service.implementation.OdontologoService;
import com.consultorio.API.service.implementation.PacienteService;
import com.consultorio.API.service.implementation.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private ITurnoService turnoService;
    private IOdontologoService odontologoService;
    private IPacienteService pacienteService;

    @Autowired
    public TurnoController(TurnoService turnoService, OdontologoService odontologoService, PacienteService pacienteService){
        this.turnoService = turnoService;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }


    //endpoint para guardar un turno
    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno){
        ResponseEntity<Turno> response;

        //verificar que exista el paciente
        if (odontologoService.buscarPorId(turno.getOdontologo().getId()) != null &&
        pacienteService.buscarPorId(turno.getPaciente().getId()) != null){
            response = ResponseEntity.ok(turnoService.guardar(turno));
        } else {
            //si no existe el odontologo o el paciente
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }
}
