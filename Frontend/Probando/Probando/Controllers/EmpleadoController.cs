using Newtonsoft.Json;
using Probando.Models;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using System.Web.Mvc;

namespace Probando.Controllers
{
    public class EmpleadoController : Controller
    {
        HttpClient client;
        private List<Empleado> empleados;
        public List<Empleado> AllEmpleados
        {
            get { return this.empleados; }
        }

        private const string url = "http://10.15.69.9:8080/";
        public EmpleadoController()
        {
            this.empleados = null;
            client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        // GET: Reserva
        public async Task<ActionResult> Index()
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/empleado");
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employees = JsonConvert.DeserializeObject<List<Empleado>>(responseData);

                return View(Employees);
            }
            else
            {
                return View("Error");
            }


        }

        public ActionResult Create()
        {
            return View(new Empleado());
        }

        [HttpPost]
        public async Task<ActionResult> Create(Empleado Emp)
        {
            HttpContent httpContent = new StringContent(JsonConvert.SerializeObject(Emp), Encoding.UTF8, "application/json");

            HttpResponseMessage responseMessage = await client.PostAsync("api/empleado", httpContent);

            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Edit(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/empleado/{id_personas}?id_personas=" + id);

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Empleado>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        //The PUT Method
        [HttpPost]
        public async Task<ActionResult> Edit(int id, Empleado Emp)
        {
            HttpContent httpContent = new StringContent(JsonConvert.SerializeObject(Emp), Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PutAsync("api/empleado/" + id, httpContent);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Delete(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/empleado/{id_personas}?id_personas=" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Empleado>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

        //The DELETE method
        [HttpPost]
        public async Task<ActionResult> Delete(int id, Empleado Emp)
        {

            HttpResponseMessage responseMessage = await client.DeleteAsync("api/empleado/" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpPost]
        public async Task<ActionResult> Details(int Id, Empleado Emp)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/empleado/{id_personas}?id_personas=" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Empleado>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Details(int Id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/empleado/{id_personas}?id_personas=" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Empleado>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

    }
}