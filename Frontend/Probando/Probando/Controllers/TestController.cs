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
    public class TestController : Controller
    {
        HttpClient client;
        HttpClient client2;
        private List<LoginModel> loginModels;
        private List<Persona> personas;
        public List<LoginModel> AllLogin
        {
            get { return this.loginModels; }
        }
        public List<Persona> AllPersonas
        {
            get { return this.personas; }
        }

        private const string url = global.ip;
        public TestController()
        {
            this.loginModels = null;
            this.personas = null;
            client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
        public ActionResult Registrar()
        {

            return View(new Persona());
        }
        [HttpPost]
        public async Task<ActionResult> Registrar(Persona Emp)
        {
            HttpContent httpContent = new StringContent(JsonConvert.SerializeObject(Emp), Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PostAsync("api/persona", httpContent);

            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }


        public ActionResult Login()
        {

            return View(new LoginModel());
        }

        [HttpGet]
        public async Task<ActionResult> LoginUser()
        {
            HttpResponseMessage responseMessage = await client.GetAsync("api/persona/LOGINUSER?password=online&usuario=online");
            if (responseMessage.IsSuccessStatusCode)
            {
                Session["id_empleado"] = 0;
                Session["id_cliente"] = 1;
                //metodopara rescatar los datos que trae responseMessage y guardarlos en una variablñe de sesion
                var responseData = responseMessage.Content.ReadAsStringAsync().Result;
                try
                {
                    Cliente cli = JsonConvert.DeserializeObject<Cliente>(responseData);
                    Session["tipo"] = cli.personaCliente.tipo;
                }
                catch (Exception)
                {
                    Empleado emp = JsonConvert.DeserializeObject<Empleado>(responseData);
                    Session["tipo"] = emp.personaEmpleado.tipo;
                }
                return RedirectToAction("../HOME");
            }
            return RedirectToAction("Login");
        }

        [HttpPost]
        //public JsonResult LoginUser(RegistrationViewModel model)
        //{            

        //    SiteUser user = db.SiteUsers.SingleOrDefault(x => x.EmailId == model.EmailId && x.Password == model.Password);
        //    string result = "fail";
        //    if (user != null)
        //    {

        //        Session["UserId"] = user.UserId;
        //        Session["UserName"] = user.UserName;
        //        if (user.RoleId == 3)
        //        {
        //            result = "GeneralUser";

        //        }
        //        else if (user.RoleId == 1)
        //        {
        //            result = "Admin";

        //        }

        //    }
        //    return Json(result, JsonRequestBehavior.AllowGet);
        //}
        public async Task<ActionResult> Login(LoginModel cli)
        {
            var cliSon = JsonConvert.SerializeObject(cli);
            HttpContent httpContent = new StringContent(cliSon, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await client.PostAsync("api/persona", httpContent);

            if (responseMessage.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Error");
        }


        public ActionResult Logout()
        {

            Session.Clear();
            Session.Abandon();

            return RedirectToAction("Login");

        }


    }
}