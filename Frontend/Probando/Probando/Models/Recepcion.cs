using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Recepcion
    {
        public int id_recepcion { get; set; }
        public int pedidos_id_pedidos { get; set; }
        public DateTime fecha { get; set; }
        public int cantidad { get; set; }
        public int id_emp_recep { get; set; }
        public Pedido pedido { get; set; }
    }
}