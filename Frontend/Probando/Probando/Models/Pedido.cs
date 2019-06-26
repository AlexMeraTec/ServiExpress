using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Pedido
    {
        public int id_pedidos { get; set; }
        public bool estado { get; set; }
        public int empleados_id_personas { get; set; }
        public DateTime fecha { get; set; }
    }
}