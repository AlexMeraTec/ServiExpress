<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Editar.aspx.cs" Inherits="Probando.reservaasp.Editar" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
     <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/start/jquery-ui.css" />
     <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css"/>
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

    <style type="text/css">
        .auto-style1 {
            height: 888px;
            width: 1485px;
        }
    </style>

</head>
<body style="font-size:12px;color:aliceblue">
  <form id="form2" runat="server">
    
     <div class="auto-style1" style="background-image:url('../../Content/images/demo/backgrounds/01.png');">

      <asp:Panel ID="Panel1" runat="server" Height="240px" style="margin-left: 264px" Width="252px">
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <asp:Label ID="Label1" runat="server" Text="Seleccione Reserva a Modificar"></asp:Label>
          <br />
          <br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <asp:DropDownList ID="ddlReserva" runat="server">
          </asp:DropDownList>
          <br />
          <br />
          <br />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          
               <asp:Button ID="btnElegir" runat="server" Text="Seleccionar" OnClick="btnElegir_Click" />
          <br />
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      </asp:Panel>
    
     </div>

    </form>
</body>
</html>
