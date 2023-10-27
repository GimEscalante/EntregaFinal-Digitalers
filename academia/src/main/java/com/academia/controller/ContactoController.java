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
import com.academia.entity.Contacto;
import com.academia.services.ContactoService;

@RestController
@RequestMapping("/api/v1")
public class ContactoController {
    
    @Autowired
    private ContactoService contactoService;

    @GetMapping("/contactos")
    public List<Contacto> obtenerContactos(){
        return contactoService.obtenerContactos();
        
    }

    @GetMapping("/contacto/{id}")
    public Contacto obtenerContactoPorId(@PathVariable Integer id){
        return contactoService.obtenerContactoPorId(id);
    }

    @PostMapping("/contacto")
    public Contacto agregarContacto(@RequestBody Contacto contacto) {
        return contactoService.agregarContacto(contacto);
    }

    @DeleteMapping("/contacto/{id}")
    public void eliminarContactoPorId(@PathVariable Integer id){
        contactoService.eliminarContactoPorId(id);
    }

    @PutMapping("/contacto/{id}")
    public Contacto modificarContacto(@PathVariable Integer id, @RequestBody Contacto contacto){
        return contactoService.modificarContacto(id, contacto);
    }

}
