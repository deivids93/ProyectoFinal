/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cabanas.cabanas.Interface;

import cabanas.cabanas.Modelo.Cabana;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author david
 */
public interface InterfaceCabin extends CrudRepository<Cabana,Integer>{
    
}
