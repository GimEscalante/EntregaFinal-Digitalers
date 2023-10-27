package com.academia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.entity.Contacto;
import com.academia.repository.ContactoRepository;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;
    
    public List<Contacto> obtenerContactos(){
        return contactoRepository.findAll();
        
    }

    public Contacto obtenerContactoPorId(Integer id){
        return contactoRepository.findById(id).orElse(null);
    }

    public Contacto agregarContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    public void eliminarContactoPorId(Integer id){
        contactoRepository.deleteById(id);

    }

    public Contacto modificarContacto(Integer id, Contacto contacto){
        Optional<Contacto> optionalContacto = contactoRepository.findById(id);
        if (optionalContacto.isPresent()){
            Contacto nuevoContacto = optionalContacto.get();
            nuevoContacto.setEmail(contacto.getEmail());
            nuevoContacto.setTelefono(contacto.getTelefono());
            nuevoContacto.setDireccion(contacto.getDireccion());
            nuevoContacto.setCiudad(contacto.getCiudad());
            nuevoContacto.setProvincia(contacto.getProvincia());
            nuevoContacto.setCodigoPostal(contacto.getCodigoPostal());
            return  nuevoContacto;
        }
        return null;
        
    }

}
