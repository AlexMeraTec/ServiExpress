﻿using Newtonsoft.Json;
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
    public class TipoController : Controller
    {
        HttpClient client;
        private List<Tipo> tipos;
        public List<Tipo> AllTipos
        {
            get { return this.tipos; }
        }

        private const string url = "http://10.15.69.9:8080/";
        public TipoController()
        {
            this.tipos = null;
            client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        // GET: Reserva
        public async Task<ActionResult> Index()
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/tipo");

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var clientes = JsonConvert.DeserializeObject<List<Tipo>>(responseData);

                return View(clientes);
            }
            else
            {

                return View("Error");
            }


        }

        public ActionResult Create()
        {
            return View(new Tipo());
        }

        [HttpPost]
        public async Task<ActionResult> Create(Tipo cli)
        {
            var cliSon = JsonConvert.SerializeObject(cli);
            HttpContent httpContent = new StringContent(cliSon, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PostAsync("api/tipo", httpContent);

            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Edit(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/tipo/{id_tipos}?id_tipos=" + id);

            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Tipo>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        //The PUT Method
        [HttpPost]
        public async Task<ActionResult> Edit(int id, Tipo Emp)
        {
            var cliSon = JsonConvert.SerializeObject(Emp);
            HttpContent httpContent = new StringContent(cliSon, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PutAsync("api/tipo/" + id, httpContent);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Delete(int id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/tipo/{id_tipos}?id_tipos=" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Tipo>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

        //The DELETE method
        [HttpPost]
        public async Task<ActionResult> Delete(int id, Tipo Emp)
        {

            HttpResponseMessage responseMessage = await client.DeleteAsync("api/tipo/" + id);
            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }
        [HttpPost]
        public async Task<ActionResult> Details(int Id, Tipo Emp)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/tipo/{id_tipos}?id_tipos =" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Tipo>(responseData);

                return View(Employee);
            }
            return View("Error");
        }
        [HttpGet]
        public async Task<ActionResult> Details(int Id)
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/tipo/{id_tipos}?id_tipos=" + Id);
            if (responseMessage.IsSuccessStatusCode)
            {
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;

                var Employee = JsonConvert.DeserializeObject<Tipo>(responseData);

                return View(Employee);
            }
            return View("Error");
        }

    }
}