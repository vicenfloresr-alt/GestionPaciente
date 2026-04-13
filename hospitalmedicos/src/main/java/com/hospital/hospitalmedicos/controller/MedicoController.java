package com.hospital.hospitalmedicos.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalmedicos.model.Medico;
import com.hospital.hospitalmedicos.service.MedicoService;

@RestController
@RequestMapping("api/v1/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService; 


    @GetMapping
    public ResponseEntity<List<Medico>> listar(){
        List<Medico> medicos = medicoService.mostrarMedicos();
        if(medicos.isEmpty()){
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.ok(medicos);
        
    }
    @PostMapping
    public ResponseEntity<Medico> guardarMedico(@RequestBody Medico unMedico){
        Medico medicoNuevo= medicoService.crearMedico(unMedico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoNuevo);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Medico> buscarMedico(@PathVariable Long id){
        try{
            Medico medico = medicoService.buscarPorId(id);
            return ResponseEntity.ok(medico);
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping ("/{id}")
    public ResponseEntity<Medico> modificar(@PathVariable Long id,@RequestBody Medico unMedico){
        try{
            Medico med = medicoService.buscarPorId(id);
            med.setId(id);
            med.setNombreCompleto(unMedico.getNombreCompleto());
            med.setRun_medico(unMedico.getRun_medico());
            med.setEspecialidad(unMedico.getEspecialidad());
            med.setJefeTurno(unMedico.getJefeTurno());
            medicoService.crearMedico(med);
            return ResponseEntity.ok(med);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public String eliminarMedico(@PathVariable Long id){
        try{
            medicoService.eliminarMedico(id);
            return "el medico ha sido eliminado";
        }
        catch (Exception e){
            return "el medico no existe";
        }
    }
    

}
