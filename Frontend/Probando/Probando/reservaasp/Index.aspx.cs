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
        //declaro la direccion y el puerto por el que hacemos el pedido a la api 

        static String host = "http://18.228.155.93:8080";//"54.233.167.87"; cambiar localhost por la direccion que este en linea
        
        //Puede parecer tedioso pero ayuda cuando cambiamos el servidor o el puerto
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == false)
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
            List<int> s = new List<int>();
            s.Add(2);
            List<string> r = new List<string>();
            r.Add();
            var reserva = new Reserva()
            {
               id_cliente = int.Parse(txtid_cliente.Text),
                id_empleado = int.Parse(txtid_empleado.Text),
            fecha = f.Date.Add(h),
                id_reservas = 0,
                observaciones =TextBox1.Text,
                se_atendio = chkse_atendio.Checked,
               servicios = s,

            };
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
                




         }
    }
}