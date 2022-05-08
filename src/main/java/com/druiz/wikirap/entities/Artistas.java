package com.druiz.wikirap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_artistas")
public class Artistas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identificador")
	private int id;
	@Column(name = "nombre_artistico")
	private String nombreartistico;
	@Column(name = "nombre_nacimiento")
	private String nombreNacimiento;
	@Column(name = "imagen")
	private String imagen;
	@Column(name = "fecha_nacimiento")
	private String fechaNacimiento;
	@Column(name = "edad")
	private Integer edad;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "nacionalidad")
	private String nacionalidad;
	@Column(name = "detalles")
	private String detalles;

	// CONSTRUCTORES

	// constructor vacio
	public Artistas() {
		super();
	}

	public Artistas(int id, String nombreartistico, String nombreNacimiento, String imagen, String fechaNacimiento, Integer edad,
			String sexo, String nacionalidad, String detalles) {
		super();
		this.id = id;
		this.nombreartistico = nombreartistico;
		this.nombreNacimiento = nombreNacimiento;
		this.imagen = imagen;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.detalles = detalles;
	}

	public Artistas(String nombreartistico, String nombreNacimiento, String imagen, String fechaNacimiento, Integer edad,
			String sexo,String nacionalidad, String detalles) {
		super();
		this.nombreartistico = nombreartistico;
		this.nombreNacimiento = nombreNacimiento;
		this.imagen = imagen;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.detalles = detalles;
	}

	
	//
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreartistico() {
		return nombreartistico;
	}

	public void setNombreartistico(String nombreartistico) {
		this.nombreartistico = nombreartistico;
	}

	public String getNombreNacimiento() {
		return nombreNacimiento;
	}

	public void setNombreNacimiento(String nombreNacimiento) {
		this.nombreNacimiento = nombreNacimiento;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Integer getEdad() {
		return edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
}
