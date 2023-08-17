package com.example.DAW3_RRHH.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empleado {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   Integer id;
    
   String nombre;
   String apellido;
   Integer salario;
   String puesto;

   @CreationTimestamp
   @Column(name = "fecha")
   LocalDateTime fecha;

   public Empleado(){}

   public Empleado(String nombre, String apellido, Integer salario, String puesto,LocalDateTime fecha){
    this.nombre = nombre;
    this.apellido = apellido;
    this.salario = salario;
    this.puesto = puesto;
    this.fecha = fecha;
   }

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellido() {
    return apellido;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public Integer getSalario() {
    return salario;
}

public void setSalario(Integer salario) {
    this.salario = salario;
}

public String getPuesto() {
    return puesto;
}

public void setPuesto(String puesto) {
    this.puesto = puesto;
}

public LocalDateTime getFecha() {
    return fecha;
}

public void setFecha(LocalDateTime fecha) {
    this.fecha = fecha;
}

   
   
}
