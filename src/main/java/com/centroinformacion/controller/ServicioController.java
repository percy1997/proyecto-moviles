package com.centroinformacion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.centroinformacion.entity.Servicio;
import com.centroinformacion.service.ServicioServices;

@RestController
@RequestMapping("/url/servicio")
public class ServicioController {

	@Autowired
	private ServicioServices repo;
	
	@GetMapping("/lista")
	public List<Servicio> listaServicio(){
		List<Servicio> lstSalida = repo.listarServicios();
		return lstSalida;
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public Servicio registrarServicio(@RequestBody Servicio s) {
		return repo.registrarServicio(s);
	}
}
