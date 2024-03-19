package com.consultorio.API.entity;

import java.time.LocalDate;

public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fechaDeAlta;
    private String domicilio;

    public Paciente(Long id, String nombre, String apellido, Integer dni, LocalDate fechaDeAlta, String domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeAlta = fechaDeAlta;
        this.domicilio = domicilio;
    }

    public Paciente(String nombre, String apellido, Integer dni, LocalDate fechaDeAlta, String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaDeAlta = fechaDeAlta;
        this.domicilio = domicilio;
    }

    public Paciente() {
    }
}
