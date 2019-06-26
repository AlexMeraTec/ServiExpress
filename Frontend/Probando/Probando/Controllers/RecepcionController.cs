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
    public class RecepcionController : Controller
    {
        HttpClient client;
        private List<Recepcion> recepciones;
        public List<Recepcion> AllRecepciones
        {
            get { return this.recepciones; }
        }

        private const string url = "http://10.15.69.9:8080/";
        public RecepcionController()
        {
            this.recepciones = null;
            client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        // GET: Reserva
        public async Task<ActionResult> Index()
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/recepcion");

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var clientes = JsonConvert.DeserializeObject<List<Recepcion>>(responseData);

                return View(clientes);
            }
            else
            {

                return View("Error");
            }


        }

        public ActionResult Create()
        {
            return View(new Recepcion());
        }

        [HttpPost]
        public async Task<ActionResult> Create(Recepcion cli)
        {
            var cliSon = JsonConvert.SerializeObject(cli);
            HttpContent httpContent = new StringContent(cliSon, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PostAsync("api/recepcion", httpContent);

            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Edit(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/recepcion/{id_recepcion}?id_recepcion=" + id);

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Recepcion>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        //The PUT Method
        [HttpPost]
        public async Task<ActionResult> Edit(int id, Recepcion Emp)
        {
            var cliSon = JsonConvert.SerializeObject(Emp);
            HttpContent httpContent = new StringContent(cliSon, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PutAsync("api/recepcion/" + id, httpContent);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Delete(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/recepcion/{id_recepcion}?id_recepcion=" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Recepcion>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

        //The DELETE method
        [HttpPost]
        public async Task<ActionResult> Delete(int id, Recepcion Emp)
        {

            HttpResponseMessage responseMessage = await client.DeleteAsync("api/recepcion/" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpPost]
        public async Task<ActionResult> Details(int Id, Recepcion Emp)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/recepcion/{id_recepcion}?id_recepcion =" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Recepcion>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Details(int Id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/recepcion/{id_recepcion}?id_recepcion=" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Recepcion>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

    }
}