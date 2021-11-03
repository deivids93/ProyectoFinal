/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cabanas.cabanas.Web;

import cabanas.cabanas.Modelo.Administrador;
import cabanas.cabanas.Servicios.ServiciosAdmin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AdminWeb {
       @Autowired
    private ServiciosAdmin servicios;
    @GetMapping("/all")
    public List <Administrador> getAdmin(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Administrador> getCliente(@PathVariable("id") int adminid) {
        return servicios.getAdmin(adminid);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador save(@RequestBody Administrador admin) {
        return servicios.save(admin);
    }
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador update(@RequestBody Administrador admin) {
        return servicios.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int adminid) {
        return servicios.deleteClient(adminid);
    }
}
