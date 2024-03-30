package com.consultorio.API.controller;

import com.consultorio.API.entity.Paciente;
import com.consultorio.API.service.IOdontologoService;
import com.consultorio.API.service.IPacienteService;
import com.consultorio.API.service.implementation.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService pacienteService;
    @Autowired
    public PacienteController (PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    //Guardar un paciente
    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }
    //buscar por id
    @GetMapping("/id/{id}")
    public ResponseEntity<Paciente> buscarId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }
    //listar todos
    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }
    //actualizar paciente
    @PutMapping
    public  ResponseEntity<String> actualizar(@RequestBody Paciente paciente){
        ResponseEntity<String> response;
        //verificar que existe
        Paciente pacienteBuscado = pacienteService.buscarPorId(paciente.getId());
        if (pacienteBuscado != null) {
            pacienteService.actualizar(paciente);
            response = ResponseEntity.ok("Se actualizo a el paciente " + paciente.getNombre());
        }else {
            response = ResponseEntity.ok().body("No se puedo actualizar al paciente");
        }
        return response;
    }
    //Eliminar paciente


}
