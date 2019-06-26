$(function () {

    //Array para dar formato en español 
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


    $(".datefield").datepicker($.datepicker.regional["es"]);
});
$(function () {
    $('#fecha').datepicker({
        beforeShowDay: $.datepicker.noWeekends
    });
});
$(function () {
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
    });
});
