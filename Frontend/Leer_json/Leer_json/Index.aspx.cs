using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;
using Newtonsoft.Json;
using System.Web.Script.Serialization;
using System.Net;


namespace Leer_json
{
    public partial class Index : System.Web.UI.Page
    {
        int select_id;
        Reserva reserva = new Reserva();

        protected void Page_Load(object sender, EventArgs e)
        {

            if (IsPostBack == false)
            {
                WebClient http = new WebClient();
                String url = "http://localhost:8080/api/servicio";
                string fileJson = http.DownloadString(url); // File.ReadAllText(@"C:\Users\vina\Desktop\Leer_json\Leer_json\servicios.json");
                JavaScriptSerializer jsd = new JavaScriptSerializer();
                List<Servivio> lstserv = (List<Servivio>)jsd.Deserialize(fileJson, typeof(List<Servivio>));




                foreach (Servivio ser in lstserv)
                {
                    ddlservicios.DataSource = lstserv;
                    ddlservicios.DataValueField = "id";
                    ddlservicios.DataTextField = "nombre";
                    ddlservicios.DataBind();

                }
            }
            


        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Reserva reserva = new Reserva();

            reserva.nombre = txtnombre.Text;
            reserva.fecha = txtFechaLaborables.Value;
            reserva.servicio = ddlservicios.SelectedIndex;
            reserva.hora = Text2.Value;



            Session["ARCHIVOJSON"] = JsonConvert.SerializeObject(reserva);
            File.WriteAllText(@"C:\Users\arekkusu888\Desktop\Leer_json\hola.json", "[" + Session["ARCHIVOJSON"].ToString() + "]");
            Response.Write("<script>alert('json creado');</script>");
            TextBox1.Text = "";

        }
    }
}