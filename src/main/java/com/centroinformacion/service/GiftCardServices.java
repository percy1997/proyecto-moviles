package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.dao.GiftCardRepository;
import com.centroinformacion.entity.GiftCard;

@Service
public class GiftCardServices {
	
	@Autowired
	private GiftCardRepository repo;
	
	//listar
	public List<GiftCard> listarGiftCard(){
		return repo.findAll();
	}
	
	//registrar
	public GiftCard registrarGiftCard(GiftCard gc) {
		return repo.save(gc);
	}
}
