using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Vehiculo
    {
        public int id_personas { get; set; }
        public string patente { get; set; }
        public char tipo { get; set; }
        public string modelo { get; set; }
        public string color { get; set; }
        public DateTime anio { get; set; }
        public string motor { get; set; }
    }
}