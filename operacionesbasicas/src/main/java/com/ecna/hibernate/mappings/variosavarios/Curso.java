package com.ecna.hibernate.mappings.variosavarios;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
	private Long id;
	private String nombre;
	@ToString.Exclude @EqualsAndHashCode.Exclude Set<Profesor> profesores;
}
