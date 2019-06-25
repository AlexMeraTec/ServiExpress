/**
 * 
 */
package com.serviexpress.serviexpress.vista.resources.vo;

import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class ProveedorVO {
	private int id_proveedor;
	private String rubro;
	private String nombre;
	private String direccion;
	private int telefono;
	private String e_mail;
	private boolean activo;
}
