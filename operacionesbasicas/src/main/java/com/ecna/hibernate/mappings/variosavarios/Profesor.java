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
public class Profesor {
	private Long id;
	private String nombre;
	private String apellidos;
	//PARA EL SET NECESITAMOS QUE ESTE IMPLEMENTADO EL EQUALS
	//Lombok por defecto lo hace con @Data
	@ToString.Exclude @EqualsAndHashCode.Exclude private Set<Curso> cursos;
}
