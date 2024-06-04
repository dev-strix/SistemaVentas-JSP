/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(function(){
    //alert("funcionando Carrito js");
    //por metodo JQuery
    $('tr #deleteitem').click(function(e){
        //esta linea es para q no se nos recargue la pagina
        e.preventDefault();
        //alert("funcionando Carrito js, deleteitem");
        var elemento = $(this);
        //devolvemos por ajax
        var idproducto = elemento.parent().find('#idarticulo').text();
        //alert(idproducto);
        $.ajax({
            url: 'borraritem',
            type: 'POST',
            data: {idproducto:idproducto},
            success: function (r) {
                //alert('desde AJAX: '+r);
                //lo que hace esta linea es eliminar el HTML, mientras mas 
                //parent elimine, eliminara al padre xq "elemento, borraritem" tiene unas etiquetas padre
                //lo que resulta q se eliminara la etiqueta completa llamando desde su etiqueta hijo
                elemento.parent().parent().remove();
                var elementostabla = $('#shop-table tr');
                if (elementostabla.length <= 1) {
                    $('#cart-container').append('<h3>No Hay Articulos en el Carrito De Compras</h3>');
                }
                $('#txt-subtotal').text(r);
                $('#txt-total').text(r);
            }
        });
    });

});

//algoritmo para hacer confirmacion de compras btn click a otro btn invisible
var enlace = document.getElementById("ejecutarcompra");
var ejecutar = document.getElementById("ejecutar");
var formtotal=document.getElementById("formtotal");

//boton visible
enlace.onclick = function(){
    alert('btn 1 si funciona');
    ejecutar.click();
};
//boton oculto
ejecutar.onclick = function (){
    //este script te redirecciona al servlet
    alert('Boton 2 si funciona');
    formtotal.submit();
};

/*
//algoritmo para hacer click en el submit del form formtotal, para agregar la venta
formtotal.addEventListener("submit", function(event){
    //event.preventDefault(); este codigo es para no enviar el formulario realmente, SOLO PARA SIMULACIONES
    //alert("Simulacion de formulario enviado");
});
//para la llamada al submit de arriba xd
function enviarVenta(){
    formtotal.submit();
}
*/
 
