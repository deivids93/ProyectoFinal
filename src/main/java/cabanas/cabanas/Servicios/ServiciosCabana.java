/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabanas.cabanas.Servicios;

import cabanas.cabanas.Modelo.Cabana;
import cabanas.cabanas.Repositorio.CabanaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosCabana {
        @Autowired
    private CabanaRepositorio metodosCrud;
    
    public List<Cabana> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Cabana> getCabana(int idCabana){
        return metodosCrud.getCabana(idCabana);
    }
    
    public Cabana save(Cabana cabana){
        if(cabana.getId()==null){
            return metodosCrud.save(cabana);
        }else{
            Optional<Cabana> evt=metodosCrud.getCabana(cabana.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(cabana);
            }else{
                return cabana;
            }
        }
    }
    public Cabana update(Cabana cabana){
        if(cabana.getId()!=null){
            Optional<Cabana> e=metodosCrud.getCabana(cabana.getId());
            if(!e.isEmpty()){
                if(cabana.getName()!=null){
                    e.get().setName(cabana.getName());
                }
                if(cabana.getBrand()!=null){
                    e.get().setBrand(cabana.getBrand());
                }
                if(cabana.getRooms()!=null){
                    e.get().setRooms(cabana.getRooms());
                }
                if(cabana.getDescription()!=null){
                    e.get().setDescription(cabana.getDescription());
                }
                if(cabana.getCategory()!=null){
                    e.get().setCategory(cabana.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cabana;
            }
        }else{
            return cabana;
        }
    }


    public boolean deleteCabana(int cabanaId) {
        Boolean aBoolean = getCabana(cabanaId).map(cabana -> {
            metodosCrud.delete(cabana);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
