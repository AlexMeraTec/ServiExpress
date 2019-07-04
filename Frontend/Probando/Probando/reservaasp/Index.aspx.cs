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
using System.Text;
using Probando.Models;

namespace Leer_json
{
    public partial class Index : System.Web.UI.Page
    {


        static String host = "http://18.228.155.93:8080";
        protected void Page_Load(object sender, EventArgs e)
        {
           int sesion = (int)Session["id_cliente"];
            int sse = (int)Session["id_empleado"];
            txtid_cliente.Text = sesion.ToString();
            txtid_empleado.Text = sse.ToString();
            if (!Page.IsPostBack)
            {

                //local
                //string fileJson = File.ReadAllText(@"C:\Users\vina\Desktop\Leer_json\Leer_json\servicios.json");
                //por URL
                var http = new WebClient();
                string fileJson = http.DownloadString(host+"/api/servicio");
                //creamos un objeto que controla la serealizacion o desealizacion
                JavaScriptSerializer jsd = new JavaScriptSerializer();
                //deserealizamos una lista de servicios que nos va a llegar
                List<Servicio> lstserv = (List<Servicio>)jsd.Deserialize(fileJson, typeof(List<Servicio>));

                foreach (Servicio ser in lstserv)
                {
                    ddlservicios.DataSource = lstserv;
                    ddlservicios.DataValueField = "id_servicios";
                    ddlservicios.DataTextField = "nombre";
                    ddlservicios.DataBind();

                }
            }


        }

        protected void Button1_Click(object sender, EventArgs e)
        {

            DateTime f = DateTime.Parse(txtFechaLaborables.Value.ToString());
                        
           
           TimeSpan  h = TimeSpan.Parse(Text2.Value.ToString());



            var reserva = new Reserva();

            int s;
            reserva.id_cliente = int.Parse(txtid_cliente.Text);
            reserva.id_empleado = int.Parse(txtid_empleado.Text);
            reserva.fecha = f.Date.Add(h);
            reserva.id_reservas = 0;
            reserva.observaciones = TextBox1.Text;
            reserva.se_atendio = chkse_atendio.Checked;
            s = int.Parse(ddlservicios.SelectedValue);
            reserva.servicios = new List<int>();
            reserva.servicios.Add(s);
            reserva.nombreCliente = "";
            reserva.nombreEmpleado = "";


            try
            {
                string json = JsonConvert.SerializeObject(reserva);
                var httpWebRequest = (HttpWebRequest)WebRequest.Create(host + "/api/reserva");
                httpWebRequest.ContentType = "application/json; charset=utf-8";
                httpWebRequest.Method = "POST";
                httpWebRequest.Accept = "application/json; charset=utf-8";

                using (var streamWriter = new StreamWriter(httpWebRequest.GetRequestStream()))
                {
                    streamWriter.Write(json);
                    streamWriter.Flush();
                    streamWriter.Close();

                    var httpResponse = (HttpWebResponse)httpWebRequest.GetResponse();
                    using (var streamReader = new StreamReader(httpResponse.GetResponseStream()))
                    {
                        var result = streamReader.ReadToEnd();
                    }

                }

                Response.Redirect("~/Reserva");

            }
            catch (Exception )
            {

            }

         }
    }
}