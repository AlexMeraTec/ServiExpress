using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Servicio
    {
        public int id_servicios { get; set; }
        public string nombre { get; set; }
        public bool activo { get; set; }
        public int precio { get; set; }
    }
}