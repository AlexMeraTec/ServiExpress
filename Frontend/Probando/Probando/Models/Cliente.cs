using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Cliente
    {
        public int id_cliente { get; set; }
        public bool natural_empresa { get; set; }
        public Persona personaCliente { get; set; }
        public bool fiable { get; set; }
    }
}