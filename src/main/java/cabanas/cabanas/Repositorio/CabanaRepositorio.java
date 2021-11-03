/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabanas.cabanas.Repositorio;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cabanas.cabanas.Interface.InterfaceCabin;
import cabanas.cabanas.Modelo.Cabana;

/**
 *
 * @author USUARIO
 */
@Repository
public class CabanaRepositorio {
      @Autowired
    private InterfaceCabin crud;
    

    public List<Cabana> getAll(){
        return (List<Cabana>) crud.findAll();       
    }
    
    public Optional <Cabana> getCabana(int id){
        return crud.findById(id);
    }
    
    public Cabana save(Cabana cabana){
        return crud.save(cabana);
    }
     public void delete(Cabana cabana){
        crud.delete(cabana);
    }
    
}
