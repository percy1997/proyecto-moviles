package com.centroinformacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.GiftCard;
import com.centroinformacion.service.GiftCardServices;



@RestController
@RequestMapping("/url/giftcard")
public class GiftCardController {
	
	@Autowired
	private GiftCardServices gifSer;
	
	@GetMapping("/lista")
	public List<GiftCard> listaGiftCard(){
		List<GiftCard> lstSalida = gifSer.listarGiftCard();
		return lstSalida;
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public GiftCard registrarGiftCard(@RequestBody GiftCard gf) {
		return gifSer.registrarGiftCard(gf);
	}
	
}