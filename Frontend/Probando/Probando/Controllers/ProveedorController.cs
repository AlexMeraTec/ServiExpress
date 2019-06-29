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
    public class ProveedorController : Controller
    {
        HttpClient client;
        private List<Proveedor> proveedores;
        public List<Proveedor> AllProveedores
        {
            get { return this.proveedores; }
        }

        private const string url = global.ip;
        public ProveedorController()
        {
            this.proveedores = null;
            client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        // GET: Reserva
        public async Task<ActionResult> Index()
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/proveedor");

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var clientes = JsonConvert.DeserializeObject<List<Proveedor>>(responseData);

                return View(clientes);
            }
            else
            {

                return View("Error");
            }


        }

        public ActionResult Create()
        {
            return View(new Proveedor());
        }

        [HttpPost]
        public async Task<ActionResult> Create(Proveedor cli)
        {
            var cliSon = JsonConvert.SerializeObject(cli);
            HttpContent httpContent = new StringContent(cliSon, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PostAsync("api/proveedor", httpContent);

            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Edit(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/proveedor/{id_proveedor}?id_proveedor=" + id);

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Proveedor>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        //The PUT Method
        [HttpPost]
        public async Task<ActionResult> Edit(int id, Proveedor Emp)
        {
            var cliSon = JsonConvert.SerializeObject(Emp);
            HttpContent httpContent = new StringContent(cliSon, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PutAsync("api/proveedor/" + id, httpContent);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Delete(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/proveedor/{id_proveedor}?id_proveedor=" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Proveedor>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

        //The DELETE method
        [HttpPost]
        public async Task<ActionResult> Delete(int id, Proveedor Emp)
        {

            HttpResponseMessage responseMessage = await client.DeleteAsync("api/proveedor/" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpPost]
        public async Task<ActionResult> Details(int Id, Proveedor Emp)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/proveedor/{id_proveedor}?id_proveedor =" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Proveedor>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Details(int Id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/proveedor/{id_proveedor}?id_proveedor=" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Proveedor>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

    }
}