using Newtonsoft.Json;
using Probando.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;

namespace Probando.Controllers
{
    public class HomeController : Controller
    {

        HttpClient client;
        private List<Servicio> servicios;
        public List<Servicio> AllServicios
        {
            get { return this.servicios; }
        }
        private const string url = global.ip;
        public HomeController()
        {
            Persona p = new Persona();
            p.nombre = "Usuario Sin Nombre";
            //session["usuario"] = p;
            this.servicios = null;
            client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        public async Task<ActionResult> Index()
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/servicio");

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var servi = JsonConvert.DeserializeObject<List<Servicio>>(responseData);

                return View(servi);
            }
            else
            {

                return View("Error");
            }


        }

       

        

        

    }

}