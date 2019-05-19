using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;
using Newtonsoft.Json;
using System.Web.Script.Serialization;
using System.Data;

namespace Leer_json
{
    public partial class Index : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string fileJson = File.ReadAllText(@"C:\GitHub\ServiExpress\Frontend\Leer_json\Leer_json\servicios.json");
            //JavaScriptSerializer jsd = new JavaScriptSerializer();
            //List<Servicio> lstserv = (List<Servicio>)jsd.Deserialize(fileJson, typeof(List<Servicio>));
            
           /* DropDownList ddl = new DropDownList();
            foreach (Servicio ser in lstserv)
            {

                DropDownList1.DataSource = lstserv;
                DropDownList1.DataValueField = "id";
                DropDownList1.DataTextField = "nombre";
                DropDownList1.DataBind();
            }*/

            //si vas a llenar una tabla 

            DataTable dt = (DataTable)JsonConvert.DeserializeObject(fileJson, typeof(DataTable));
            GridView1.DataSource = dt;
            GridView1.DataBind();
        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
        
        protected void Button1_Click(object sender, EventArgs e)
        {
            Reserva reserva = new Reserva
            { nombre = TextBox1.Text,
                fecha = Calendar1.SelectedDate,
                servicio = DropDownList1.SelectedValue,

            };
            Session["ARCHIVOJSON"] = JsonConvert.SerializeObject(reserva);
            File.WriteAllText(@"C:\Users\arekkusu888\Desktop\Leer_json\Leer_json\hola.json", "[" + Session["ARCHIVOJSON"].ToString() + "]");
            Response.Write("<script>alert('json creado');</script>");
        }
        }
                

        }
        
    
