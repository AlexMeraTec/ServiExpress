using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Persona
    {

        public int id_personas { get; set; }
        public int rut { get; set; }
        public String digito_verificador { get; set; }
        public String nombre { get; set; }
        public String paterno { get; set; }
        public String materno { get; set; }
        public String direccion { get; set; }
        public int telefono { get; set; }
        public int telefono2 { get; set; }
        public String usuario { get; set; }
        public String password { get; set; }
        public String e_mail { get; set; }
        public bool activa { get; set; }
        public bool tipo { get; set; }
    }
}