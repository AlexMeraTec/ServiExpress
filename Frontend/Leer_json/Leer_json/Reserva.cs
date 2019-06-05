using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Leer_json
{
    public class Reserva
    {
        public int clientes_id_personas { get; set; }
        public int empleados_id_personas { get; set; }
        public DateTime fecha { get; set; }
        public string observaciones { get; set; }
        public int id_reservas { get; set; }
        public Boolean se_atendio { get; set; }
    }
}