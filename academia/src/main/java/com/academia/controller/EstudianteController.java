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
import com.academia.entity.Estudiante;
import com.academia.services.EstudianteService;

@RestController
@RequestMapping("/api/v1")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/estudiantes")
    public List<Estudiante> obtenerEstudiantes(){
        return estudianteService.obtenerEstudiantes();
    }

    @GetMapping("/estudiante/{id}")
    public Estudiante obtenerEstudiantePorId(@PathVariable Integer id){
        return estudianteService.obtenerEstudiantePorId(id);
    }

    @PostMapping("/estudiante")
    public Estudiante agregarEstudiante(@RequestBody Estudiante estudiante){
        return estudianteService.agregarEstudiante(estudiante);
    }

    @DeleteMapping("/estudiante/{id}")
    public void eliminarEstudiantePorId(@PathVariable Integer id){
        estudianteService. eliminarEstudiantePorId(id);

    }

    @PutMapping("/estudiante/{id}")
    public Estudiante modificarEstudiante(@PathVariable Integer id, @RequestBody Estudiante e){
        return estudianteService.modificarEstudiante(id, e);
    }
}
