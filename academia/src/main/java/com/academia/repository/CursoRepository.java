package com.academia.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.academia.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    
}
