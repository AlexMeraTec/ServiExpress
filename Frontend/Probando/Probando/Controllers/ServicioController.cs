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
    public class ServicioController : Controller
    {
        HttpClient client;
        private List<Servicio> servicios;
        public List<Servicio> AllServicios
        {
            get { return this.servicios; }
        }

        private const string url = "http://10.15.69.9:8080/";
        public ServicioController()
        {
            this.servicios = null;
            client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        // GET: Reserva
        public async Task<ActionResult> Index()
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/servicio");

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var clientes = JsonConvert.DeserializeObject<List<Servicio>>(responseData);

                return View(clientes);
            }
            else
            {

                return View("Error");
            }


        }

        public ActionResult Create()
        {
            return View(new Servicio());
        }

        [HttpPost]
        public async Task<ActionResult> Create(Servicio cli)
        {
            var cliSon = JsonConvert.SerializeObject(cli);
            HttpContent httpContent = new StringContent(cliSon, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PostAsync("api/servicio", httpContent);

            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Edit(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/servicio/{id_servicios}?id_servicios=" + id);

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Servicio>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        //The PUT Method
        [HttpPost]
        public async Task<ActionResult> Edit(int id, Servicio Emp)
        {
            var cliSon = JsonConvert.SerializeObject(Emp);
            HttpContent httpContent = new StringContent(cliSon, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PutAsync("api/servicio/" + id, httpContent);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Delete(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/servicio/{id_servicios}?id_servicios=" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Servicio>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

        //The DELETE method
        [HttpPost]
        public async Task<ActionResult> Delete(int id, Servicio Emp)
        {

            HttpResponseMessage responseMessage = await client.DeleteAsync("api/servicio/" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpPost]
        public async Task<ActionResult> Details(int Id, Servicio Emp)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/servicio/{id_servicios}?id_servicios =" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Cliente>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Details(int Id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/cliente/{id_cliente}?id_cliente=" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Servicio>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

    }
}