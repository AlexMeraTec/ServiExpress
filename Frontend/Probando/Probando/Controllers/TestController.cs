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

namespace MVCTutorial.Controllers
{
    public class TestController : Controller
    {
        HttpClient client;
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

        private const string url = "http://localhost:8080/";
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