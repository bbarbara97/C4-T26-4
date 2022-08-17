package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MaquinasRegistradoras")//en caso que la tabla sea diferente
public class Equipos {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int numSerie;
		@Column(name = "nombre")//no hace falta si se llama igual
		private String nombre;
		
		@OneToMany
	    @JoinColumn(name="numSerie")
	    private List<Reserva> reserva;
		
		@ManyToOne
	    @JoinColumn(name = "codigo")
	    Facultad facultad;

		//Constructores
		
		public Equipos() {

		}

		public Equipos(int numSerie, String nombre, List<Reserva> reserva, Facultad facultad) {
			super();
			this.numSerie = numSerie;
			this.nombre = nombre;
			this.reserva = reserva;
			this.facultad = facultad;
		}

		//Getters y Setters
		
		public int getNumSerie() {
			return numSerie;
		}

		public void setNumSerie(int numSerie) {
			this.numSerie = numSerie;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
		public List<Reserva> getReserva() {
			return reserva;
		}

		public void setReserva(List<Reserva> reserva) {
			this.reserva = reserva;
		}

		public Facultad getFacultad() {
			return facultad;
		}

		public void setFacultad(Facultad facultad) {
			this.facultad = facultad;
		}
		
		//Metodo toString
		
		@Override
		public String toString() {
			return "Equipos [numSerie=" + numSerie + ", nombre=" + nombre + ", reserva=" + reserva + ", facultad="
					+ facultad + "]";
		}
}
