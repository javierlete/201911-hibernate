package com.ecna.hibernate.mappings.composicion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empleado {
	private Long id;
	private String nombre;
	private Dni dni;
}
