using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Probando.Controllers
{
    public class Direccion
    {
        public string apihost { get; }

        public Direccion()
        {
            this.apihost = "http://10.15.69.9:8080/";
        }
    }
}