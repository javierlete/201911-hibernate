package com.ecna.hibernate.mappings.unoavarioslist;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movimiento {
	private Long id;
	private Date fecha;
	private String concepto;
	private BigDecimal importe;
}
