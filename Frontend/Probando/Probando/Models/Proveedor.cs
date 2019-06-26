using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Proveedor
    {
        public int id_proveedor { get; set; }
        public string rubro { get; set; }
        public string nombre { get; set; }
        public string direccion { get; set; }
        public int telefono { get; set; }
        public string e_mail { get; set; }
        public bool activo { get; set; } 
    }
}