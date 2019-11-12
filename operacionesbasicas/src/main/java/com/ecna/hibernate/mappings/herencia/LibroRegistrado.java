package com.ecna.hibernate.mappings.herencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LibroRegistrado extends Libro {
	private String isbn;
	
	public LibroRegistrado(Long id, String nombre, String isbn) {
		super(id, nombre);
		setIsbn(isbn);
	}

	@Override
	public String toString() {
		return super.toString() + ", LibroRegistrado [isbn=" + isbn + "]";
	}
}
