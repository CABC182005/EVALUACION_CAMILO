package com.example.evaluacion_camilo.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluacion_camilo.interfaceService.I_tareasService;
import com.example.evaluacion_camilo.models.tareas;
import com.example.evaluacion_camilo.service.emailService;






@RequestMapping("/api/v1/tareas")
@RestController
@CrossOrigin
@Validated

public class tareasController {

    
    	@Autowired
	private I_tareasService tareasService;

	
    @Autowired
    private emailService emailService;
	
	@PostMapping("/tasks")
    public ResponseEntity<Object> save(@RequestBody tareas tareas) {
        tareas.setDue_date(new Date()); // Asigna la fecha de actualización actual
        tareasService.save(tareas);
        emailService.enviarCorreoBienvenida(tareas.getAssigned_to()); // Uso correcto
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }
        

	
	
	@GetMapping("/tasks")
	public ResponseEntity<Object> findAll(){
		var listatareas=tareasService.findAll();
		return new ResponseEntity<>(listatareas,HttpStatus.OK);
	}
	

	
	@GetMapping("/tasks{id}")
	public ResponseEntity<Object> findOne(@PathVariable("id") String id){
		var tareas=tareasService.findOne(id);
		return new ResponseEntity<>(tareas,HttpStatus.OK);
	}

	
	
	@DeleteMapping("/tasks{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id){
		tareasService.delete(id);
		return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/tasks{id}")
	public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody tareas tareasUpdate){
		var tareas= tareasService.findOne(id).get();
		
		if (tareas != null) {
			tareas.setTitle(tareasUpdate.getTitle());
			tareas.setDue_date(tareasUpdate.getDue_date());
			tareas.setAssigned_to(tareasUpdate.getAssigned_to());
			tareas.setStatus(tareasUpdate.getStatus());
			tareasService.save(tareas);
			return new ResponseEntity<>("Guardado",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error tareas no encontrado",HttpStatus.BAD_REQUEST);
		}
		
	}

}