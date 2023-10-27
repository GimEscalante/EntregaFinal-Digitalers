package com.academia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.academia.entity.Curso;
import com.academia.services.CursoService;

@RestController
@RequestMapping("/api/v1")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public List<Curso> obtenerCursos(){
        return cursoService.obtenerCursos();
    }

    @GetMapping("/curso/{id}")
    public Curso obtenerCursoPorId(@PathVariable Integer id){
        return cursoService.obtenerCursoPorId(id);
    }

    @PostMapping("/curso")
    public Curso agregarCurso(@RequestBody Curso curso){
        return cursoService.agregarCurso(curso);
    }

    @DeleteMapping("/curso/{id}")
    public void eliminarCursoPorId(@PathVariable Integer id){
        cursoService. eliminarCursoPorId(id);
    }

    @PutMapping("/curso/{id}")
    public Curso modificarCurso(@PathVariable Integer id, @RequestBody Curso curso){
        return cursoService.modificarCurso(id, curso);
    }

}
