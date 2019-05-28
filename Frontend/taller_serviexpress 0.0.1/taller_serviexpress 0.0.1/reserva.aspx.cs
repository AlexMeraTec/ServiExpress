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
using System.Net.Security;

namespace taller_serviexpress_0._0._1
{
    public partial class reserva : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == false)
            {
                string fileJson = File.ReadAllText(@"C:\Users\vina\Desktop\Leer_json\Leer_json\servicios.json");
                JavaScriptSerializer jsd = new JavaScriptSerializer();
                List<Servicio> lstserv = (List<Servicio>)jsd.Deserialize(fileJson, typeof(List<Servicio>));
                foreach (Servicio ser in lstserv)
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
            //Reserva reserva = new Reserva
            //{
            //    nombre = txtnombre.Text,
            //    fecha = txtFechaLaborables.Value,
            //    servicio = ddlservicios.SelectedIndex,
            //    hora = Text2.Value,

            //};

            //Session["ARCHIVOJSON"] = JsonConvert.SerializeObject(reserva);
            //File.WriteAllText(@"C:\Users\vina\Desktop\Leer_json\Leer_json\hola.json", "[" + Session["ARCHIVOJSON"].ToString() + "]");
            //Response.Write("<script>alert('json creado');</script>");
            //TextBox1.Text = "";

            var reserva = new Reserva();
            ServicePointManager.ServerCertificateValidationCallback = new RemoteCertificateValidationCallback(
           delegate { return true; }
           );
            var httpWebRequest = (HttpWebRequest)WebRequest.Create("");
            httpWebRequest.ContentType = "application/json; charset=utf-8";
            httpWebRequest.Accept = "application/json";
            httpWebRequest.Method = "POST";
            using (var streamWriter = new StreamWriter(httpWebRequest.GetRequestStream()))
            {
                string json = JsonConvert.SerializeObject(reserva);

                streamWriter.Write(json);
                streamWriter.Flush();
                streamWriter.Close();
            }

            var httpResponse = (HttpWebResponse)httpWebRequest.GetResponse();
            using (var streamReader = new StreamReader(httpResponse.GetResponseStream()))
            {
                var result = streamReader.ReadToEnd();
                Response.Write(" < script > alert('Reserva Guardada');</ script > ");

            }
        }
    }
}