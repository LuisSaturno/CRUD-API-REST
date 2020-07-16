package com.telcel.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TUSUARIO")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String A_Paterno;
	private String A_Materno;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TROLE")
	private Roles rol;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getA_Paterno() {
		return A_Paterno;
	}

	public void setA_Paterno(String a_Paterno) {
		A_Paterno = a_Paterno;
	}

	public String getA_Materno() {
		return A_Materno;
	}

	public void setA_Materno(String a_Materno) {
		A_Materno = a_Materno;
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}

}
