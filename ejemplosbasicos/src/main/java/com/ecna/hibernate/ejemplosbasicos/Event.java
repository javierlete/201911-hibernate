package com.ecna.hibernate.ejemplosbasicos;

import java.util.Date;

public class Event {
	private Long id;

	private String title;
	private Date date;
	private Integer posicion;
	private String observaciones;

	public Event() {
		// this form used by Hibernate
	}

	public Event(String title, Date date, Integer posicion, String observaciones) {
		// for application use, to create new events
		this.title = title;
		this.date = date;
		this.posicion = posicion;
		this.setObservaciones(observaciones);
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPosicion() {
		return posicion;
	}

	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}