using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Producto
    {
        public string id_productos { get; set; }
        public string nombre { get; set; }
        public DateTime fecha_vencimiento { get; set; }
        public Proveedor id_proveedor { get; set; }
        public Tipo id_tipos { get; set; }
        public Familia id_familias { get; set; }
        public int precio_compra { get; set; }
        public int precio_venta { get; set; }
        public int stock { get; set; }
        public int stock_critico { get; set; }
        public bool activo { get; set; }

    }
}