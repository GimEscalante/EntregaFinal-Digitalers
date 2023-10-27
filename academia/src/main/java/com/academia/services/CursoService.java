package com.academia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.Curso;
import com.academia.repository.CursoRepository;

@Service
public class CursoService {
    

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerCursos(){
        return cursoRepository.findAll();

    }

    public Curso obtenerCursoPorId(Integer id){
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso agregarCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public void eliminarCursoPorId(Integer id){
        cursoRepository.deleteById(id);
    }

    public Curso modificarCurso(Integer id, Curso curso){
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isPresent()){
            Curso nuevoCurso = optionalCurso.get();
            nuevoCurso.setNombre(curso.getNombre());
            return nuevoCurso;
        }
        return null;

    } 
}
