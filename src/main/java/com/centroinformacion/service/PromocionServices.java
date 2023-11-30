package com.centroinformacion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.centroinformacion.dao.PromocionRepository;
import com.centroinformacion.entity.Promocion;

@Service
public class PromocionServices {
	
	@Autowired
	private PromocionRepository repo;
	
	//listar
	public List<Promocion> listarPromociones(){
		return repo.findAll();
	}
	
	//grabar 
	public Promocion registrarPromocion(Promocion p) {
		return repo.save(p);
	}
	
	//buscar
	public Promocion buscarPromocion(int cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void eliminarPromocion(int cod) {
		repo.deleteById(cod);
	}
}
