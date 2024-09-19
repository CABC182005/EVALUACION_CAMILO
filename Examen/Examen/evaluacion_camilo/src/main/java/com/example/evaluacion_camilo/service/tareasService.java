package com.example.evaluacion_camilo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.evaluacion_camilo.interfaceService.I_tareasService;
import com.example.evaluacion_camilo.interfaces.I_tareas;
import com.example.evaluacion_camilo.models.tareas;

@Service
public class tareasService implements I_tareasService{
    
    @Autowired
    private I_tareas data;




    @Override
    public List<tareas> findAll() {
        List<tareas> listatareas = (List<tareas>) data.findAll();
        
        return listatareas;
    }


//   @Override
//     public List<tareas> filtrotareas(String filtro) {
//         return data.filtrotareas(filtro);
//     }


    @Override
    public Optional<tareas> findOne(String id) {
        Optional<tareas> tareas = data.findById(id);
        
        return tareas;
    }

    @Override
    public int delete(String id) {
        data.deleteById(id);
        return 1;
    }

    @Override
    public String save(tareas tareas) {
        data.save(tareas);
        return tareas.getId();
    }


  
    @Override
    public List<tareas> iniciosesionNotificar(String iniciosesionNotificar) {
        List<tareas> listatareas = data.iniciosesionNotificar(iniciosesionNotificar);
        return listatareas;
    }


   

}
