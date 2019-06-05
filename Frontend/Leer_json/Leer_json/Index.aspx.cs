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

namespace Leer_json
{
    public partial class Index : System.Web.UI.Page
    {
        //declaro la direccion y el puerto por el que hacemos el pedido a la api 
        static String puerto = "8080";
        static String host = "http://localhost:";//"54.233.167.87"; cambiar localhost por la direccion que este en linea
        String url = host + puerto;
        //Puede parecer tedioso pero ayuda cuando cambiamos el servidor o el puerto
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == false)
            {

                //local
                //string fileJson = File.ReadAllText(@"C:\Users\vina\Desktop\Leer_json\Leer_json\servicios.json");
                //por URL
                var http = new WebClient();
                string fileJson = http.DownloadString(url+"/api/servicio");
                //creamos un objeto que controla la serealizacion o desealizacion
                JavaScriptSerializer jsd = new JavaScriptSerializer();
                //deserealizamos una lista de servicios que nos va a llegar
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

            var reserva = new Reserva()
            {
                clientes_id_personas = 3,
                empleados_id_personas = 1,
                fecha = DateTime.Parse("2019-05-01T14:08:53.819Z"),
                id_reservas = 1,
                observaciones ="Hola Pelao",
                se_atendio = false,
            };
            string json = JsonConvert.SerializeObject(reserva);
            var httpWebRequest = (HttpWebRequest)WebRequest.Create(url + "/api/reserva");
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
                /*
                var request = (HttpWebRequest)WebRequest.Create(host+"/api/reserva");
                request.Method = "POST";
                request.ContentType = "application/json; charset=utf-8";
                request.Timeout = 30000;


                byte[] byteArray = Encoding.UTF8.GetBytes(json);
                //request.ContentLength = byteArray.Length;

                var dataStream = new StreamWriter(request.GetRequestStream());
                dataStream.Write(byteArray);
                dataStream.Close();


                using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
                {
                    dataStream = response.GetResponseStream();
                    using (Stream stream = response.GetResponseStream())
                    {
                        using (StreamReader reader = new StreamReader(stream))
                        {
                            string responseFromServer = reader.ReadToEnd();
                        }
                    }
                }
                */




         }
    }
}