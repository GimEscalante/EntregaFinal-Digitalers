package com.academia.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.Instructor;
import com.academia.repository.InstructorRepository;

@Service
public class InstructorService {
    

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> obtenerInstructores(){
        return instructorRepository.findAll();
    }

    public Instructor obtenerInstructorPorId(Integer id){
        return instructorRepository.findById(id).orElse(null);
    }

    public Instructor agregarInstructor(Instructor instructor){
        return instructorRepository.save(instructor);
    }

    public void eliminarInstructorPorId(Integer id){
        instructorRepository.deleteById(id);
    }

    public Instructor modificarInstructor(Integer id, Instructor instructor){
        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);
        if(optionalInstructor.isPresent()){
            Instructor nuevoInstructor = optionalInstructor.get();
            nuevoInstructor.setNombre(instructor.getNombre());
            nuevoInstructor.setApellido(instructor.getApellido());
            return nuevoInstructor;
        }
        return null;
    } 

}
