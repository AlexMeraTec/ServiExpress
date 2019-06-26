using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using System.Web.Mvc;
using Newtonsoft.Json;
using Probando.Models;

namespace Probando.Controllers
{
    public class PersonaController : Controller
    {
        HttpClient client;
        private List<Persona> personas;
        public List<Persona> AllPersonas {
            get { return this.personas; }
        }

        //The URL of the WEB API Service
        private const string url = "http://10.15.69.9:8080/";
         
        //The HttpClient Class, this will be used for performing 
        //HTTP Operations, GET, POST, PUT, DELETE
        //Set the base address and the Header Formatter
        public PersonaController()
        {
            this.personas = null;
            client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }

        // GET: EmployeeInfo
        public async Task<ActionResult> Index()
        {   
            HttpResponseMessage responseMessage = await client.GetAsync("api/persona");
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employees = JsonConvert.DeserializeObject<List<Persona>>(responseData);

                return View(Employees);
            }
            else
            {    
                return View("Error");
            }
            

        }

        public ActionResult Create()
        {
            return View(new Persona());
        }

        //The Post method
        [HttpPost]
        public async Task<ActionResult> Create(Persona Emp)
        {
            HttpContent httpContent = new StringContent(JsonConvert.SerializeObject(Emp), Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PostAsync("api/persona", httpContent);

            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Edit(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/persona/{id_personas}?id_personas=" + id);

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;
                var Employee = JsonConvert.DeserializeObject<Persona>(responseData);
                return View(Employee);
            }
            return View("Error");
        }
        //The PUT Method
        [HttpPost]
        public async Task<ActionResult> Edit(int id, Persona Emp)
        {
            HttpContent httpContent = new StringContent(JsonConvert.SerializeObject(Emp), Encoding.UTF8,"application/json");
            HttpResponseMessage responseMessage = await client.PutAsync("api/persona/" + id, httpContent);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Delete(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/persona/{id_personas}?id_personas=" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Persona>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

        //The DELETE method
        [HttpPost]
        public async Task<ActionResult> Delete(int id, Persona Emp)
        {

            HttpResponseMessage responseMessage = await client.DeleteAsync("api/persona/" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpPost]
        public async Task<ActionResult> Details(int Id, Persona Emp)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/persona/{id_personas}?id_personas=" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Persona>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Details(int Id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/persona/{id_personas}?id_personas=" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Persona>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        
    }
}