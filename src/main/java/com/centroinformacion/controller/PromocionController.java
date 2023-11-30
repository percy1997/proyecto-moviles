package com.centroinformacion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.dao.PromocionRepository;
import com.centroinformacion.entity.Promocion;
import com.centroinformacion.service.PromocionServices;

@RestController
@RequestMapping("/url/promocion")
public class PromocionController {

	@Autowired
	private PromocionServices repo;
	
	@Autowired
	private PromocionRepository repository;
	
	@GetMapping("/lista")
	public List<Promocion> listaPromocion(){
		List<Promocion> lstSalida = repo.listarPromociones();
		return lstSalida;
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public Promocion registrarPromocion(@RequestBody Promocion p) {
		return repo.registrarPromocion(p);
	}
	
	@PutMapping("/{cod}")
	public Promocion actualizarPromocion(@PathVariable Integer cod, @RequestBody Promocion promocionActualizada) {
	    return repository.findById(cod)
	            .map(promocion -> {
	                promocion.setNombrePromocion(promocionActualizada.getNombrePromocion());
	                promocion.setDescripcionPromocion(promocionActualizada.getDescripcionPromocion());
	                promocion.setMontoPromocion(promocionActualizada.getMontoPromocion());
	                promocion.setImagenPromocion(promocionActualizada.getImagenPromocion());
	                promocion.setFechaPromocion(promocionActualizada.getFechaPromocion());
	                promocion.setTipoPromo(promocionActualizada.getTipoPromo());

	                return repository.save(promocion);
	            })
	            .orElse(null);
	}

    
    @GetMapping("/{cod}")
    public Promocion obtenerPorId(@PathVariable int cod) {
        return repo.buscarPromocion(cod);
    }
    
    @DeleteMapping("/{cod}")
    public void eliminarUsuario(@PathVariable int cod) {
    	repo.eliminarPromocion(cod); 
    }
}
