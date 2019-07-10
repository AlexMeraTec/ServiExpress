<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="Leer_json.Index" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/start/jquery-ui.css" />
     <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css"/>
    <style type="text/css">
        .auto-style2 {
            height: 1050px;
            margin-top: 0px;
        }
    </style>
    <link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script src="jquery.ui.datepicker-es.js"></script>
    <script src="jquery.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
   
  <script type="text/javascript">
 $.datepicker.regional['es'] = {
 closeText: 'Cerrar',
 prevText: '< Ant',
 nextText: 'Sig >',
 currentText: 'Hoy',
 monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
 monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
 dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
 dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
 weekHeader: 'Sm',
 dateFormat: 'yy/mm/dd',
     firstDay: 1,
 
 isRTL: false,
 showMonthAfterYear: false,
 yearSuffix: ''
      };
      $.datepicker.setDefaults($.datepicker.regional['es']);
      $(document).ready(function() {
          $('#txtFechaLaborables').datepicker({
            changeMonth: true,
            changeYear: true,
         beforeShowDay: function (day) { 
           var day = day.getDay(); 
           if (day == 6|| day == 0) { 
             return [false, "somecssclass"] 
           } else { 
             return [true, "someothercssclass"] 
           } 
            },
            minDate:'+0d'
          })
          
    $('#Text2').timepicker({
    timeFormat: 'HH:mm ',
    interval: 60,
    minTime: '09:00',
    maxTime: '18:00',
    defaultTime: '09',
    startTime: '09:00',
    dynamic: false,
    dropdown: true,
    scrollbar: true
});
});; 
          
      //});
      

  </script> 

</head>
<body style="font-size:12px;color:aliceblue; height: 1049px;">    
  <form id="form1" runat="server">  
      <div class="auto-style2" style="background-image:url('../../Content/images/demo/backgrounds/01.png');">
      <asp:Panel ID="Panel1" runat="server" Height="167px">
          <asp:Label ID="lblnombre" runat="server" Text="ID_Cliente"></asp:Label>
          &nbsp;
          <asp:TextBox ID="txtid_cliente" runat="server" Width="225px"></asp:TextBox>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <asp:Label ID="Label1" runat="server" Text="ID_Empleado"></asp:Label>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <asp:TextBox ID="txtid_empleado" runat="server" style="margin-left: 35px" Width="131px" ReadOnly="True"></asp:TextBox>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <br />
          <br />
          <asp:Label ID="lblObservaciones" runat="server" Text="Observaciones"></asp:Label>
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <asp:TextBox ID="TextBox1" runat="server" Width="191px" Height="78px" TextMode="MultiLine"></asp:TextBox>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:CheckBox ID="chkse_atendio" runat="server" Text="Se Atendio" />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</asp:Panel>
  
    <p>Seleccione una fecha:
      <input id="txtFechaLaborables" type="text"  readonly="readonly" runat="server"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Label ID="Label2" runat="server" Text="Seleccione un servicio"></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:DropDownList ID="ddlservicios" runat="server" AutoPostBack="True">
        </asp:DropDownList>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hora&nbsp;
           <input id="Text2" type="text"  readonly="readonly" runat="server"/></p>
      <p>
           &nbsp;<asp:Button ID="Button1" runat="server" OnClick="Button1_Click" style="margin-left: 275px" Text="Guardar" />
      </p>
          <div>
              <ul>
                  <li class="active"><a href="../HOME">Inicio</a></>
              </ul>
          </div>
          </div>
      </form>      
</body>
</html>
