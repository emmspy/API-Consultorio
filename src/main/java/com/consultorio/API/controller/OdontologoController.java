package com.consultorio.API.controller;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.service.IOdontologoService;
import com.consultorio.API.service.implementation.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private IOdontologoService odontologoService;

    @Autowired
    public OdontologoController (OdontologoService odontologoService){

        this.odontologoService = odontologoService;
    }
    //buscar odontologo por id
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    //buscar odontologo por matricula
    @GetMapping("/matricula/{numeroMatricula}")
    public ResponseEntity<Odontologo> buscarMatricula(@PathVariable Integer numeroMatricula) throws Exception {
        Optional<Odontologo> odontologoOptional = odontologoService.findByMatricula(numeroMatricula);

        if (odontologoOptional.isPresent()){
            return ResponseEntity.ok(odontologoOptional.get());
        }else {
            throw new Exception("No se encontro el odontologo con la matricula " + numeroMatricula);
        }
    }
    //lista todos los odontologos
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos() {
        return ResponseEntity.ok(odontologoService.listarTodos());
    }

    //Actualizar un odontologo
    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody Odontologo odontologo){
        ResponseEntity<String> response = null;
        Odontologo odontologoBuscado = odontologoService.buscarPorId(odontologo.getId());

        if (odontologoBuscado != null ){
            odontologoService.actualizar(odontologo);
            response = ResponseEntity.ok("Se ha actualizado el odontologo " + odontologo.getNombre());
        } else{
            response = ResponseEntity.ok().body("No se puede actualizar el odontologo");
        }
        return response;
    }
    //eliminar un odontologo

}
