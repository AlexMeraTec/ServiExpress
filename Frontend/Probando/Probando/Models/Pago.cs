using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Models
{
    public class Pago
    {
        public int id_pago { get; set; }
        public DateTime fecha { get; set; }
        public bool boleta_factura { get; set; }
        public int total_neto { get; set; }
        public int descuento { get; set; }
        public int total_final { get; set; }
        public bool anulada { get; set; }
        public int id_reservas { get; set; }

    }
}