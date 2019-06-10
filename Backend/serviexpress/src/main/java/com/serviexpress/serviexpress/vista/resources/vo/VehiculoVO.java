package com.serviexpress.serviexpress.vista.resources.vo;

import java.util.Date;
import lombok.Data;

/**
 * @author arekkusu888
 *
 */
@Data
public class VehiculoVO {
	private int id_personas;
	private String patente;
	private char tipo;
	private String modelo;
    private String color;
    private Date anio;
    private String motor;
}