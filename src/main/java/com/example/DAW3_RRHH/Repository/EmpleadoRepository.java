package com.example.DAW3_RRHH.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.DAW3_RRHH.models.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado,Integer>{

    List<Empleado> findAll();

}
