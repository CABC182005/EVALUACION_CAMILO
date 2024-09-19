package com.example.evaluacion_camilo.models;




import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class tareas {
    

    
    @Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id", nullable=false, length = 36)
	private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "due_date", nullable = false)
    private Date due_date;

    @Column(name = "assigned_to", nullable = false)
    private String assigned_to;

    @Column(name = "status", nullable = false)
    private String status;

    public tareas() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    


}
