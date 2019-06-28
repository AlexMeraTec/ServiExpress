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
    public class ReservaController : Controller
    {
        HttpClient client;
        private List<Reserva> reservas;
        public List<Reserva> AllReservas
        {
            get { return this.reservas; }
        }

        private const string url = global.ip;
        public ReservaController()
        {
            this.reservas = null;
            client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        // GET: Reserva
        public async Task<ActionResult> Index()
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/reserva");
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var reservas = JsonConvert.DeserializeObject<List<Reserva>>(responseData);

                return View(reservas);
            }
            else
            {

                return View("Error");
            }


        }

        public ActionResult Create()
        {
            return View(new Reserva());
        }

        [HttpPost]
        public async Task<ActionResult> Create(Reserva rva)
        {
            HttpContent httpContent = new StringContent(JsonConvert.SerializeObject(rva), Encoding.UTF8, "application/json");

            HttpResponseMessage responseMessage = await client.PostAsync("api/reserva", httpContent);

            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Edit(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/reserva/{id_reservas}?id_reservas =" + id);

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var reserva = JsonConvert.DeserializeObject<Reserva>(responseData);

                return View(reserva);
            }
            return View("Error");
        }
        //The PUT Method
        [HttpPost]
        public async Task<ActionResult> Edit(int id, Reserva rva)
        {
            HttpContent httpContent = new StringContent(JsonConvert.SerializeObject(rva), Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PutAsync("api/reserva/" + id, httpContent);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Delete(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/reserva/{id_reservas}?id_reservas =" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var reserva = JsonConvert.DeserializeObject<Reserva>(responseData);

                return View(reserva);
            }
            return View("Error");
        }

        //The DELETE method
        [HttpPost]
        public async Task<ActionResult> Delete(int id, Reserva rva)
        {

            HttpResponseMessage responseMessage = await client.DeleteAsync("api/reserva/" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpPost]
        public async Task<ActionResult> Details(int Id, Reserva rva)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/reserva/{id_reservas}?id_reservas =" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var reserva = JsonConvert.DeserializeObject<Reserva>(responseData);

                return View(reserva);
            }
            return View("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Details(int Id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/reserva/{id_reservas}?id_reservas=" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var reserva = JsonConvert.DeserializeObject<Reserva>(responseData);

                return View(reserva);
            }
            return View("Error");
        }

    }
}