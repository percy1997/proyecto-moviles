package com.centroinformacion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.centroinformacion.dao.ServicioRepository;
import com.centroinformacion.entity.Servicio;

@Service
public class ServicioServices {

	@Autowired
	private ServicioRepository repo;
	
	//listar
	public List<Servicio> listarServicios(){
		return repo.findAll();
	}
	
	//grabar 
	public Servicio registrarServicio(Servicio s) {
		return repo.save(s);
	}
}
