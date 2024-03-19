package com.consultorio.API.entity;

import java.time.LocalDate;

public class Turno {
    private Long id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDate fechaIngreso;

    public Turno(Long id, Odontologo odontologo, Paciente paciente, LocalDate fechaIngreso) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaIngreso = fechaIngreso;
    }

    public Turno(Odontologo odontologo, Paciente paciente, LocalDate fechaIngreso) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaIngreso = fechaIngreso;
    }

    public Turno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
