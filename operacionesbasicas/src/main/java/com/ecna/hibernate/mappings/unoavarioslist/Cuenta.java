package com.ecna.hibernate.mappings.unoavarioslist;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cuenta {
	private Long id;
	private String numero;
	@ToString.Exclude private List<Movimiento> movimientos;
}
