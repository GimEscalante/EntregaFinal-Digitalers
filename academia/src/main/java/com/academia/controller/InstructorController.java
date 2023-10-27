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
import com.academia.entity.Instructor;
import com.academia.services.InstructorService;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {
    
    @Autowired
    private InstructorService instructorService;
    
    @GetMapping("/instructores")
    public List<Instructor> obtenerInstructores(){
        return instructorService.obtenerInstructores();
    }

    @GetMapping("/instructor/{id}")
    public Instructor obtenerInstructorPorId(@PathVariable Integer id){
        return instructorService.obtenerInstructorPorId(id);
    }

    @PostMapping("/instructor")
    public Instructor agregarInstructor(@RequestBody Instructor instructor){
        return instructorService.agregarInstructor(instructor);
    }

    @DeleteMapping("/instructor/{id}")
    public void eliminarInstructorPorId(@PathVariable Integer id){
        instructorService. eliminarInstructorPorId(id);
    }

    @PutMapping("/instructor/{id}")
    public Instructor modificarInstructor(@PathVariable Integer id, @RequestBody Instructor instructor){
        return instructorService.modificarInstructor(id, instructor);
    }
}
