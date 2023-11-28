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
@Table(name = "promociones")
public class Promocion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_pro")
	private Integer codigoPromocion;
	
	@Column(name = "nom_pro")
	private String nombrePromocion;
	
	@Column(name = "des_pro")
	private String descripcionPromocion;
	
	@Column(name = "mon_pro")
	private double montoPromocion;
	
	@Column(name = "imagen")
	private String imagenPromocion;
	
	@Column(name = "fecha")
	private String fechaPromocion;	
	
	@ManyToOne
	@JoinColumn(name="cod_tip")
	private TipoPromocion tipoPromo;
}
