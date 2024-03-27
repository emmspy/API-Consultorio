package com.consultorio.API.service.implementation;

import com.consultorio.API.entity.Odontologo;
import com.consultorio.API.repository.IOdontologoRepository;
import com.consultorio.API.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    private IOdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(IOdontologoRepository odontologoRepository){
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        return odontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {

        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> buscarPorId(Long id) {
        Optional<Odontologo>odontologoOptional = odontologoRepository.findById(id);
        if (odontologoOptional.isPresent()){
            return odontologoRepository.findAllById(id);
        }else {
            return null;
        }
    }

    @Override
    public void eliminarPorId(Long id) {
    }

    @Override
    public void actualizar(Odontologo odontologo) {
         odontologoRepository.save(odontologo);
    }
}
