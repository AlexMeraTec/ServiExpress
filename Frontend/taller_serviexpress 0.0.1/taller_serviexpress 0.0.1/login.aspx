<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="taller_serviexpress_0._0._1.login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
    <style type="text/css">
        .auto-style1 {
            background-color: #FFFFFF;
        }
    </style>
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <asp:Login ID="login1" runat="server" LoginButtonText="Login" PasswordLabelText="password:" RememberMeText="Recordar" UserNameLabelText="usuario:" OnAuthenticate="login1_Authenticate1"></asp:Login>
    </form>
</body>
</html>
