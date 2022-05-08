package com.druiz.wikirap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_discos")
public class Discos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identificador")
	private Integer id;
	@Column(name = "portada")
	private String portada;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "autor")
	private String autor;
	@Column(name = "duracion")
	private String duracion;
	@Column(name = "fecha_estreno")
	private String fechaSalida;
	
	//Constructor vacio
	public Discos() {
		super();
	}
	
	public Discos(int id, String portada, String titulo, String autor , String duracion, String fechaSalida) {
		super();
		this.id = id;
		this.portada = portada;
		this.titulo = titulo;
		this.autor = autor;
		this.duracion = duracion;
		this.fechaSalida = fechaSalida;
	}
	
	public Discos(String portada, String titulo, String autor , String duracion, String fechaSalida) {
		super();
		this.portada = portada;
		this.titulo = titulo;
		this.autor = autor;
		this.duracion = duracion;
		this.fechaSalida = fechaSalida;
	}
	
	//GETTERS & SETTERS
	
	public int getId() {
		return id;
	}
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	
	
}