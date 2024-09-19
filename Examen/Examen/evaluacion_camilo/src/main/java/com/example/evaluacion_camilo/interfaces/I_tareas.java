package com.example.evaluacion_camilo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.evaluacion_camilo.models.tareas;

@Repository
public interface I_tareas extends CrudRepository<tareas, String>  {


}

