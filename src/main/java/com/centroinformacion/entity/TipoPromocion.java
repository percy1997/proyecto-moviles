package com.centroinformacion.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tipo_promo")
public class TipoPromocion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tip")
	private Integer codigoTipoPromo;
	
	@Column(name = "nom_tip")
	private String nombreTipoPromo;	
	
	@OneToMany(mappedBy = "tipoPromo")
	@JsonIgnore
	private List<Promocion> listaPromocion;
}
