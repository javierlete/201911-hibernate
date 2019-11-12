package com.ecna.hibernate.mappings.mapas;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Encounter {
	private Long id;
	private String nombre;
	private Map<String, String> asistentes;
}
