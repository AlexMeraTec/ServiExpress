using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Reserva
    {
        public int id_reservas { get; set; }

        [System.ComponentModel.DisplayName("fecha")]
        public DateTime fecha { get; set; }
        public string observaciones { get; set; }        
        public bool se_atendio { get; set; }
        public int id_cliente { get; set; }
        public int id_empleado { get; set; }

        public List<int> servicios { get; set; }
        public List<string> productos { get; set; }
    }
}