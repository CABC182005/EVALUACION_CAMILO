package com.example.evaluacion_camilo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.evaluacion_camilo.models.tareas;

public interface I_tareasService {
    
    public String save(tareas tareas);    
    public List<tareas> findAll();
    public Optional<tareas> findOne(String id);
    public int delete(String id);

}
