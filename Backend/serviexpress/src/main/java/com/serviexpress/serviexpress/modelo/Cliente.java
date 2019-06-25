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
}
