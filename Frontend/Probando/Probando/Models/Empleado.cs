using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Empleado
    {
        public int id_empleado { get; set; }
        public int nivel_acceso { get; set; }
        public Persona personaEmpleado { get; set; }
    }
}