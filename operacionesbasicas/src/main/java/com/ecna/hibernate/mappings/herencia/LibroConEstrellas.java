package com.ecna.hibernate.mappings.herencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LibroConEstrellas extends Libro {
	private int estrellas;
	
	public LibroConEstrellas(Long id, String nombre, int estrellas) {
		super(id, nombre);
		setEstrellas(estrellas);
	}

	@Override
	public String toString() {
		return super.toString() + ", LibroConEstrellas [estrellas=" + estrellas + "]";
	}
}
