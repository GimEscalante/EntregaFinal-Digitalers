package com.academia.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.academia.entity.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{



}
