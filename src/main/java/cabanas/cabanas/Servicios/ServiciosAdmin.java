/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabanas.cabanas.Servicios;

import cabanas.cabanas.Modelo.Administrador;
import cabanas.cabanas.Repositorio.AdminRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosAdmin {
        @Autowired
    private AdminRepositorio metodosCrud;
    
    public List<Administrador> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Administrador> getAdmin(int adminId){
        return metodosCrud.getAdmin(adminId);
    }
    
    public Administrador save(Administrador admin){
        if(admin.getIdAdmin()==null){
            return metodosCrud.save(admin);
        }else{
            Optional<Administrador> evt=metodosCrud.getAdmin(admin.getIdAdmin());
            if(evt.isEmpty()){
                return metodosCrud.save(admin);
            }else{
                return admin;
            }
        }
    }
     public Administrador update(Administrador admin){
        if(admin.getIdAdmin()!=null){
            Optional<Administrador> e= metodosCrud.getAdmin(admin.getIdAdmin());
            if(!e.isEmpty()){
                if(admin.getName()!=null){
                    e.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    e.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    e.get().setPassword(admin.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }

    public boolean deleteClient(int adminId) {
        Boolean aBoolean = getAdmin(adminId).map(admin -> {
            metodosCrud.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
