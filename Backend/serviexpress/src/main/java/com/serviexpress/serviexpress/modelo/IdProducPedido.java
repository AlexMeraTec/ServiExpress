package com.serviexpress.serviexpress.modelo;

import java.io.Serializable;
import java.util.Objects;

public class IdProducPedido implements Serializable{
	protected String id_productos;
	protected int id_pedidos;
	
	 @Override
	    public int hashCode() {
	        int hash = 7;
	        hash = 59 * hash + Objects.hashCode(this.id_pedidos);
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
	        final IdProducPedido other = (IdProducPedido) obj;
	        if (!Objects.equals(this.id_productos, other.id_productos)) {
	            return false;
	        }
	        if (!Objects.equals(this.id_pedidos, other.id_pedidos)) {
	            return false;
	        }
	        return true;
	    }

	
	
}
