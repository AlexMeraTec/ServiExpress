package com.serviexpress.serviexpress.modelo;

import java.io.Serializable;
import java.util.Objects;

public class IdProducReserva implements Serializable{
	protected String id_productos;
	protected int id_reservas;
	
	 @Override
	    public int hashCode() {
	        int hash = 7;
	        hash = 59 * hash + Objects.hashCode(this.id_reservas);
	        hash = 59 * hash + Objects.hashCode(this.id_productos);
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
	        final IdProducReserva other = (IdProducReserva) obj;
	        if (!Objects.equals(this.id_productos, other.id_productos)) {
	            return false;
	        }
	        if (!Objects.equals(this.id_reservas, other.id_reservas)) {
	            return false;
	        }
	        return true;
	    }

	
	
}
