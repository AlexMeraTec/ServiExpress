using Newtonsoft.Json;
using Probando.Models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Probando.reservaasp
{
    public partial class Editando : System.Web.UI.Page
    {

        static String host = "http://18.228.155.93:8080";
        protected void Page_Load(object sender, EventArgs e)
        {
           
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            DateTime f = DateTime.Parse(txtFechaLaborables.Value.ToString());


            TimeSpan h = TimeSpan.Parse(Text2.Value.ToString());

            int sesion = (int)Session["id_cliente"];
            int sse = (int)Session["id_empleado"];
            int Valor = int.Parse(Request.Params["Valor"]);
            var http = new WebClient();
            string reservita = http.DownloadString(host + "/api/reserva/findReservasByCliente?id_cliente=" + sesion);
            JavaScriptSerializer js = new JavaScriptSerializer();
            //deserealizamos una lista de servicios que nos va a llegar
            List<Reserva> lstres = (List<Reserva>)js.Deserialize(reservita, typeof(List<Reserva>));
            foreach (Reserva res in lstres)
            {
                if (res.id_reservas == Valor)
                {
                    Reserva reserva = new Reserva();

                    reserva.id_cliente = sesion;
                    reserva.id_empleado = sse;
                    reserva.fecha = f.Date.Add(h);
                    reserva.id_reservas = res.id_reservas;
                    reserva.observaciones = res.observaciones;
                    reserva.se_atendio = res.se_atendio;
                    reserva.servicios = res.servicios;
                    reserva.nombreCliente =res.nombreCliente;
                    reserva.nombreEmpleado = res.nombreEmpleado;

                    string json = JsonConvert.SerializeObject(reserva);
                    var httpWebRequest = (HttpWebRequest)WebRequest.Create(host + "/api/reserva/"+Valor);
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

            }
        }
    }
}