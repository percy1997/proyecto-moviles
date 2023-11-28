package com.centroinformacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "giftcard")
public class GiftCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_gif")
	private Integer codigoGift;
	
	@Column(name = "nom_gid")
	private String nombreGift;
	
	@Column(name = "mon_gif")
	private double montoGift;
	
	@ManyToOne
	@JoinColumn(name="cod_tipg")
	private TipoGift tipoGift;
}
