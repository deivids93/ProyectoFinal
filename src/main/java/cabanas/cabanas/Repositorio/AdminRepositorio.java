/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabanas.cabanas.Repositorio;

import cabanas.cabanas.Interface.InterfaceAdministrador;
import cabanas.cabanas.Modelo.Administrador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class AdminRepositorio {
      @Autowired
    private InterfaceAdministrador crud1;
    

    public List<Administrador> getAll(){
        return (List<Administrador>) crud1.findAll();       
    }
    
    public Optional <Administrador> getAdmin(int id){
        return crud1.findById(id);
    }
    
    public Administrador save(Administrador admin){
        return crud1.save(admin);
    }
     public void delete(Administrador admin){
        crud1.delete(admin);
    } 
}
