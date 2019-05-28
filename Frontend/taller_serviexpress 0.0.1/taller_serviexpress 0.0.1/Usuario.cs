using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.IO;
 

namespace taller_serviexpress_0._0._1
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Rut { get; set; }
        public string Dv { get; set; }
        public string Nombre { get; set; }
        public string Ape_Paterno { get; set; }
        public string Ape_Materno { get; set; }
        public string Direccion { get; set; }
        public int Telefono { get; set; }
        public int Telefono2 { get; set; }
        public string Email { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }

        public Usuario()
        {

        }
    }
}