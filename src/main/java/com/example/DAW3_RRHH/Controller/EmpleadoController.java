package com.example.DAW3_RRHH.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DAW3_RRHH.DTO.EmpleadoDTO;
import com.example.DAW3_RRHH.Repository.EmpleadoRepository;
import com.example.DAW3_RRHH.models.Empleado;

import org.springframework.ui.Model;

@Controller
@RequestMapping("empleados")
public class EmpleadoController {
    
    EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    @GetMapping
    public String list(Model modelo){
        List<Empleado> empleados = empleadoRepository.findAll();
        modelo.addAttribute("listaEmpleados", empleados);
        return "empleados/list";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        EmpleadoDTO empleadoDto = new EmpleadoDTO();
        model.addAttribute("empleadoForm", empleadoDto);
        return "empleados/create";
    }

    @PostMapping
    public String create(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado(empleadoDTO.getNombre(), empleadoDTO.getApellido(),
         empleadoDTO.getSalario(),empleadoDTO.getPuesto(),LocalDateTime.now());
        empleadoRepository.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if(empleadoOptional.isEmpty()) {
            return "404";
        }

        Empleado empleado = empleadoOptional.get();
        model.addAttribute("empleado", empleado);
        return "empleados/detail";
    }

    @GetMapping("{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if(empleadoOptional.isEmpty()) {
            return "404";
        }

        Empleado empleado = empleadoOptional.get();
        model.addAttribute("empleado", empleado);
        return "empleados/edit";
    }

    @PostMapping("{id}")
    public String edit(@PathVariable Integer id, Empleado empleadoDataForm) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if(empleadoOptional.isEmpty()) {
            return "404";
        }

        Empleado empleado = empleadoOptional.get();
        empleado.setNombre(empleadoDataForm.getNombre());
        empleado.setApellido(empleadoDataForm.getApellido());
        empleado.setSalario(empleadoDataForm.getSalario());
        empleado.setPuesto(empleadoDataForm.getPuesto());
        empleado.setFecha(empleadoDataForm.getFecha());
        empleadoRepository.save(empleado);

        return "redirect:/empleados";
    }

    @PostMapping("{id}/delete")
    public String delete(@PathVariable Integer id) {
        empleadoRepository.deleteById(id);
        return "redirect:/productos";
    }
}
