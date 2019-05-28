using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace taller_serviexpress_0._0._1
{
    public partial class login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                login1.Focus();

            }
        }       

        protected void login1_Authenticate1(object sender, AuthenticateEventArgs e)
        {
            //   Usuario usuario = new Usuario();

            //   if (FormsAuthentication.Authenticate(login1.UserName,
            //login1.Password))
            //   {
            //       FormsAuthentication.RedirectFromLoginPage(login1.UserName,
            //   login1.RememberMeSet);
            //   }

            try
            {
                bool Autenticado = false;
                Autenticado = LoginCorrecto(login1.UserName, login1.Password);
                e.Authenticated = Autenticado;
                if (Autenticado)
                {
                    Session["usuario"] = Autenticado;
                    Response.Redirect("index.aspx");
                }
                bool LoginCorrecto(string Usuario, string Contrasena)
                {
                    if (Usuario.Equals("admin") && Contrasena.Equals("admin123"))
                        return true; return false;
                }

            }
            catch (Exception)
            {

                throw;
            }

        }
    }
}