package com.hospital.hospitalmedicos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalmedicos.model.Medico;
import com.hospital.hospitalmedicos.repository.MedicoRepository;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

   public List<Medico> mostrarMedicos(){
    return medicoRepository.findAll();   // similar a select * from tabla

   }
   public Medico buscarPorId(Long id){
     return medicoRepository.findById(id).get(); // similar a select * from table where condicion
   }
   public Medico crearMedico(Medico unMedico){
    return medicoRepository.save(unMedico); // similar a insert into tabla
   }
   public void eliminarMedico(Long id){
    medicoRepository.deleteById(id); //similar a delete from tabla
   }
   


}
