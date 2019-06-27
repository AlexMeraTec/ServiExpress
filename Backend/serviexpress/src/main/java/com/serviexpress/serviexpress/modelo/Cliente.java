package com.serviexpress.serviexpress.modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
@Entity
@Table(name = "clientes")
@NamedQuery(name = "Cliente.findById_cliente", query = "select c,p from Cliente c join c.personaCliente p where c.id_cliente = ?1 and c.id_cliente = p.id_personas")
public class Cliente{
	@Id
	@Column(name = "id_personas")
	private int id_cliente;
	@Column(name = "natural_empresa")
	private boolean natural_empresa;//0 para natural y 1 para empresa

	@OneToOne
	@JoinColumn(name = "id_personas", updatable = false, nullable = false)
	private Persona personaCliente;

	@OneToMany(mappedBy = "clienteReserva",cascade = CascadeType.ALL)//en mappedBy debe ir el nombre que tiene esta clase dentro de la otra clase
	@JsonIgnore
	private List<Reserva> reservasCliente;
	
	@OneToMany(mappedBy = "clienteVehiculo",cascade = CascadeType.ALL)//en mappedBy debe ir el nombre que tiene esta clase dentro de la otra clase
	@JsonIgnore
	private List<Vehiculo> vehiculosCliente;
	
	@Column(name = "fiable")
	private boolean fiable;

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public boolean isNatural_empresa() {
		return natural_empresa;
	}

	public void setNatural_empresa(boolean natural_empresa) {
		this.natural_empresa = natural_empresa;
	}

	public Persona getPersonaCliente() {
		return personaCliente;
	}

	public void setPersonaCliente(Persona personaCliente) {
		this.personaCliente = personaCliente;
	}

	public List<Reserva> getReservasCliente() {
		return reservasCliente;
	}

	public void setReservasCliente(List<Reserva> reservasCliente) {
		this.reservasCliente = reservasCliente;
	}

	public List<Vehiculo> getVehiculosCliente() {
		return vehiculosCliente;
	}

	public void setVehiculosCliente(List<Vehiculo> vehiculosCliente) {
		this.vehiculosCliente = vehiculosCliente;
	}

	public boolean isFiable() {
		return fiable;
	}

	public void setFiable(boolean fiable) {
		this.fiable = fiable;
	}
	
}
