package com.serviexpress.serviexpress.modelo;

import java.io.Serializable;
import java.util.Objects;

public class IntCompuesta implements Serializable{
	protected int id_reservas;
	protected int id_servicios;
	
	 @Override
	    public int hashCode() {
	        int hash = 7;
	        hash = 59 * hash + Objects.hashCode(this.id_reservas);
	        hash = 59 * hash + Objects.hashCode(this.id_servicios);
	        return hash;
	    }

	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final IntCompuesta other = (IntCompuesta) obj;
	        if (!Objects.equals(this.id_servicios, other.id_servicios)) {
	            return false;
	        }
	        if (!Objects.equals(this.id_reservas, other.id_reservas)) {
	            return false;
	        }
	        return true;
	    }

	
	
}
