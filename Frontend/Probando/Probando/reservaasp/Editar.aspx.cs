using Probando.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Probando.reservaasp
{
    public partial class Editar : System.Web.UI.Page
    {
        static String host = "http://18.228.155.93:8080";
        int Valor;
        protected void Page_Load(object sender, EventArgs e)
        {
           if (!Page.IsPostBack)
            {

                int tg = (int)Session["id_cliente"];
                var http = new WebClient();
                string reservita = http.DownloadString(host + "/api/reserva/findReservasByCliente?id_cliente=" + tg);
                JavaScriptSerializer js = new JavaScriptSerializer();
                //deserealizamos una lista de servicios que nos va a llegar
                List<Reserva> lstres = (List<Reserva>)js.Deserialize(reservita, typeof(List<Reserva>));
                foreach (Reserva res in lstres)
                {
                    ddlReserva.DataSource = lstres;
                    ddlReserva.DataValueField = "id_reservas";
                    ddlReserva.DataTextField = "fecha";
                    ddlReserva.DataBind();
                    
                }

            }
        }

       

        protected void btnElegir_Click(object sender, EventArgs e)
        {
            Valor = int.Parse(ddlReserva.SelectedValue);
            Response.Redirect("Editando.aspx?Valor="+Valor);
        }
    }
}