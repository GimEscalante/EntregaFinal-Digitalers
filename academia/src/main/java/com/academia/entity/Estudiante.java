package com.academia.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "estudiantes")

public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido; 

    @Column(nullable = false)
    private LocalDate fechaNacimiento; 


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_contacto")
    private Contacto contacto;


    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "estudiante_curso", 
        joinColumns = @JoinColumn(name = "fk_estudiante"),
        inverseJoinColumns = @JoinColumn(name = "fk_curso"))
    private List<Curso> cursos = new ArrayList<>();



}
