/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
$(function(){
 
// primero creamos una función que va a cambiar las imágenes
 
var replaceImg=function(href){
    var img=$('#gallery #pic img').eq(0),nImg=document.createElement('img');
    $('#gallery #pic').append($(nImg).css('opacity',0));
    nImg.onload=function(){$(this).animate({opacity:1},'fast');img.remove();
    };
    nImg.src=href;
};
 
// ahora la función que va a procesar la acción del clic de ratón en la imagen de  vista previa
 
$('#gallery #thumbs li a').click(function(){
    $('#gallery #thumbs .current').removeClass('current');
    replaceImg($(this).attr('href'));
    $(this).addClass('current');
    return false;
});
 
// este código es para los botones prev/next, si son necesarios

    $('#gallery a[rel="next"],#gallery #pic img').live('click', function () {
        var curr, indx = 0, len = $('#gallery #thumbs ul li a').length;
        $('#gallery #thumbs ul li a').each(
                function () {
                    if (this.className.indexOf('current') !== -1)
                    {
                        curr = indx;
                    } else
                    {
                        indx++;
                    }
                }
        );
        $('#gallery #thumbs ul li a.current').removeClass('current');
        $('#gallery #thumbs ul li a').eq(((curr + 1) < len) ? curr + 1 : 0).addClass('current');
        replaceImg($('#gallery #thumbs ul li a.current').attr('href'));
    });
    $('#gallery a[rel="prev"]').live('click', function () {
        var curr, indx = 0, len = $('#gallery #thumbs ul li a').length;
        $('#gallery #thumbs ul li a').each(function () {
            if (this.className.indexOf('current') !== -1) {
                curr = indx;
            } else {
                indx++;
            }
        });
        $('#gallery #thumbs ul li a.current').removeClass('current');
        $('#gallery #thumbs ul li a').eq(curr - 1).addClass('current');
        replaceImg($('#gallery #thumbs ul li a.current').attr('href'));
    });
});