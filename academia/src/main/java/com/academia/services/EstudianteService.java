package com.academia.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.academia.entity.Estudiante;
import com.academia.repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> obtenerEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Estudiante obtenerEstudiantePorId(Integer id){
        Estudiante estudiante = estudianteRepository.findById(id).orElse(null);
        return estudiante;
    }

    public Estudiante agregarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);

    }

    public void eliminarEstudiantePorId(Integer id){
        estudianteRepository.deleteById(id);

    }

    public Estudiante modificarEstudiante(Integer id, Estudiante e){
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(id);
        if(optionalEstudiante.isPresent()){
            Estudiante nuevoEstudiante = optionalEstudiante.get();
            nuevoEstudiante.setNombre(e.getNombre());
            nuevoEstudiante.setApellido(e.getApellido());
            nuevoEstudiante.setFechaNacimiento(e.getFechaNacimiento());
            return nuevoEstudiante;
        }

        return null;
        
    }


}
