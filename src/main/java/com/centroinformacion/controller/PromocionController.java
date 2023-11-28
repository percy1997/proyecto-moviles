package com.centroinformacion.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.centroinformacion.entity.Promocion;
import com.centroinformacion.service.PromocionServices;

@RestController
@RequestMapping("/url/promocion")
public class PromocionController {

	@Autowired
	private PromocionServices repo;
	
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
}
