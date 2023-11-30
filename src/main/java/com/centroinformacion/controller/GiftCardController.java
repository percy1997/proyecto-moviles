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

import com.centroinformacion.dao.GiftCardRepository;
import com.centroinformacion.entity.GiftCard;
import com.centroinformacion.entity.Promocion;
import com.centroinformacion.service.GiftCardServices;



@RestController
@RequestMapping("/url/giftcard")
public class GiftCardController {
	
	@Autowired
	private GiftCardServices repo;
	
	@Autowired
	private GiftCardRepository repository;
	
	@GetMapping("/lista")
	public List<GiftCard> listaGiftCard(){
		List<GiftCard> lstSalida = repo.listarGiftCard();
		return lstSalida;
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public GiftCard registrarGiftCard(@RequestBody GiftCard gf) {
		return repo.registrarGiftCard(gf);
	}
	
	@PutMapping("/{cod}")
	public GiftCard actualizarGiftCard(@PathVariable Integer cod, @RequestBody GiftCard giftCardActualizada) {
	    return repository.findById(cod)
	            .map(giftCard -> {
	                giftCard.setNombreGift(giftCardActualizada.getNombreGift());
	                giftCard.setDescripcionGift(giftCardActualizada.getDescripcionGift());
	                giftCard.setMontoGift(giftCardActualizada.getMontoGift());
	                giftCard.setImagenGift(giftCardActualizada.getImagenGift());
	                giftCard.setFechaGift(giftCardActualizada.getFechaGift());
	                giftCard.setTipoGift(giftCardActualizada.getTipoGift());

	                return repository.save(giftCard);
	            })
	            .orElse(null);
	}


    
    @GetMapping("/{cod}")
    public GiftCard obtenerPorId(@PathVariable int cod) {
        return repo.buscarGiftCard(cod);
    }
    
    @DeleteMapping("/{cod}")
    public void eliminarUsuario(@PathVariable int cod) {
        repo.eliminarGiftCard(cod);
    }
}