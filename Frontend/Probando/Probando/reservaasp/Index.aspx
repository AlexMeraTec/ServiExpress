﻿

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
          monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
          dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
          dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Juv', 'Vie', 'Sáb'],
          dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
          weekHeader: 'Sm',
          dateFormat: 'dd/mm/yy',
          firstDay: 1,
          isRTL: false,
          showMonthAfterYear: false,
          yearSuffix: ''
      };
      $.datepicker.setDefaults($.datepicker.regional['es']);
      $(document).ready(function () {
          $('#txtFechaLaborables').datepicker({
              changeMonth: true,
              changeYear: true,
              beforeShowDay: function (day) {
                  var day = day.getDay();
                  if (day == 6 || day == 0) {
                      return [false, "somecssclass"]
                  } else {
                      return [true, "someothercssclass"]
                  }
              },
              minDate: '+0d'
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
<body style="font-size:12px;">
  <form id="form1" runat="server">
    
      <Panel ID="Panel1" runat="server" Height="130px">
          <Label ID="lblnombre" runat="server" Text="Nombre"></Label>
          &nbsp;
          <TextBox ID="txtnombre" runat="server" Width="225px"></TextBox>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <Label ID="Label1" runat="server" Text="Rut"></Label>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <TextBox ID="txtrut" runat="server" style="margin-left: 35px" Width="131px"></TextBox>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <br />
          <br />
          <Label ID="Label3" runat="server" Text="Telefono"></Label>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <TextBox ID="TextBox1" runat="server" Width="191px"></TextBox>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <Label ID="Label4" runat="server" Text="Correo"></Label>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <TextBox ID="TextBox2" runat="server" style="margin-left: 0px" Width="125px"></TextBox>
          &nbsp;</Panel>
  
    <p>Seleccione una fecha:
      <input id="txtFechaLaborables" type="text"  readonly="readonly" runat="server"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <Label ID="Label2" runat="server" Text="Seleccione un servicio"></Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <DropDownList ID="ddlservicios" runat="server" AutoPostBack="True">
        </DropDownList>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Hora&nbsp;
           <input id="Text2" type="text"  readonly="readonly" runat="server"/></p>
      </form>
</body>
</html>
